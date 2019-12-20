var pollDelay = 1000;
var continuePolling = false;
var mouseDownOnTranscript = false;  //whether the user has performed a mousedown on the transcript (including any scrollbar)
                                    //and not yet performed a mouseup

function customPostReplaceForCommentTx(element, markup) {
    //scroll to the bottom of the transcript
    var transcriptPanel = document.getElementById('form1:transcriptPanel');
    transcriptPanel.scrollTop = transcriptPanel.scrollHeight;

    //clear the text field
    var commentTextField = document.getElementById('form1:comment');
    commentTextField.value = '';

    //place focus in the text field
    commentTextField.focus();
}

function handleOnLoad() {
    //handle mousedown on the transcript
    var transcriptPanel = document.getElementById('form1:transcriptPanel');
    transcriptPanel.onmousedown = handleMouseDown;

    //handle mouseup anywhere on the page
    document.onmouseup = handleMouseUp;

    //turn autocomplete off for the text field
    document.getElementById('form1:comment').setAttribute('autocomplete','off');

    //start polling
    continuePolling = true;
    poll();
}

function handleOnUnload() {
    //stop polling
    continuePolling = false;
}

function poll() {
    //fire the pollTx Ajax Transaction
    DynaFaces.Tx.fire('pollTx');
}

function customReplaceForPollTx(element, markup) {
    //provided that the user is not performing an operation such as selecting transcript text or scrolling the transcript,
    //perform replacement (re-rendering) for this poll request,
    //and scroll the transcript as appropriate after the replacement
    if (!mouseDownOnTranscript) {
        var transcriptPanel = document.getElementById('form1:transcriptPanel');

        //scrollTop: distance between top of transcript and top of the portion currently visible
        //scrollHeight: total height of transcript, including any portion not visible due to scrolling
        //clientHeight: height of the visible portion of the transcript

        //capture whether scrollbar exists before replacement.
        //scrollbar exists if the scrollHeight exceeds the clientHeight
        var scrollbarExistsBeforeReplacement = transcriptPanel.scrollHeight > transcriptPanel.clientHeight;

        //capture whether the transcript is scrolled to the bottom before replacement
        var scrolledToBottomBeforeReplacement = false;
        if (scrollbarExistsBeforeReplacement) {
            //transcript is scrolled to the bottom if the sum of scrollTop and clientHeight equals scrollHeight
            if (transcriptPanel.scrollTop + transcriptPanel.clientHeight == transcriptPanel.scrollHeight) {
                scrolledToBottomBeforeReplacement = true;
            }
        }

        //capture the scrollTop before replacement
        var scrollTopBeforeReplacement = transcriptPanel.scrollTop;

        //invoke default replacement function to perform actual replacement of transcript content
        DynaFaces.replace(element, markup);

        //capture whether scrollbar exists after replacement
        var scrollbarExistsAfterReplacement = transcriptPanel.scrollHeight > transcriptPanel.clientHeight;

        //scroll to the bottom of the transcript if it was scrolled to the bottom before replacement
        //or if the scrollbar did not exist before replacement and it now exists after replacement.
        //otherwise, scroll the transcript to the same place it was before replacement
        if (scrolledToBottomBeforeReplacement || (!scrollbarExistsBeforeReplacement && scrollbarExistsAfterReplacement)) {
            transcriptPanel.scrollTop = transcriptPanel.scrollHeight;  //scroll to the bottom of the transcript
        }
        else {
            transcriptPanel.scrollTop = scrollTopBeforeReplacement; //scroll transcript to the place it was before replacement
        }
    }
}

function handleMouseDown() {
    //if the mousedown occurs on the transcript's scrollbar,
    //IE will not invoke the corresponding mouseup event handler when the mouse is released.
    //in such a case, do not set mouseDownOnTranscript to true, since nothing will set it back to false.
    //instead, just perform replacement in customReplaceForPollTx even though the user is scrolling the transcript,
    //as this does not seem to cause a problem on IE anyway
    if (document.all) {
        var transcriptPanel = document.getElementById('form1:transcriptPanel');
        var scrollBarExists = transcriptPanel.scrollHeight > transcriptPanel.clientHeight;
        if (scrollBarExists) {
            if (window.event.offsetX > transcriptPanel.clientWidth) {
                //mousedown occurred on the scrollbar
                return;
            }
        }
    }
    mouseDownOnTranscript = true;
}

function handleMouseUp() {
    mouseDownOnTranscript = false;
}

function customPostReplaceForPollTx(element, markup) {
    //send the next poll request
    if (continuePolling) {
        setTimeout(poll, pollDelay);
    }
}

function interceptFormSubmit() {
    //if the text field is not blank, fire commentTx
    if (document.getElementById('form1:comment').value != '') {
        DynaFaces.Tx.fire('commentTx');
    }

    //prevent conventional form submission
    return false;
}