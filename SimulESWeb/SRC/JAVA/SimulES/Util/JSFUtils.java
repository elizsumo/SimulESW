package SimulES.Util;

/**
 *
 * @author Elizabeth
 */
public class JSFUtils {

    //return random between 1 until limit
    public int generateRandom(int limit) {
        int n = 0;
        do {
            n = (int) Math.round(Math.random() * 10);
        } while (n > limit || n < 1);

        return n;
    }

    //return random between 1 until limit
    public Boolean generateRandomBug(int limit) {
        boolean isBug = true;
        int n = 0;
        do {
            n = (int) Math.round(Math.random() * 10);
        } while (n > limit || n < 1);

        if (n > 6) {
            isBug = false;
        }
        return isBug;
    }


    //return random between 1 until limit value=decimal
    public int generateRandom(int limit, int value) {
        int n = 0;
        do {
            n = (int) Math.round(Math.random() * value);
        } while (n > limit || n < 1);

        return n;
    }

    //separate each configuration that mean each (row, column, card in one space vector)
    public String[] getEachConfiguration(String configuration) {
        String[] fields = configuration.split("/");
        System.out.println(fields);
        return fields;
    }

    //separate each value that is divided by ","
    public String[] getEachValue(String value) {
        String[] values = value.split(",");

        return values;
    }

    //return separate configuration, row and column
    public String[] returnValueConfiguration(String configuration, int row, int column) {
        String[] fields = getEachConfiguration(configuration);
        String[] cards = null;
        String allValues = null;
        try {

            for (int x = 0; x < fields.length; x++) {

                String[] values = getEachValue(fields[x].toString());

                String rowAll = values[0];
                String columnAll = values[1];
                String valueAll = values[2];

                int rowLocal = Integer.parseInt(String.valueOf(rowAll.charAt(1)));
                int columnLocal = Integer.parseInt(String.valueOf(columnAll.charAt(1)));
                String value = String.valueOf(valueAll.charAt(1));

                if (rowLocal == row && columnLocal == column) {
                    if (x == 0) {
                        allValues = value;
                    } else {
                        allValues = allValues + "," + value;
                    }

                }
            }
            if (!(allValues == null)) {
                cards = allValues.split(",");
            } else {
                return cards;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cards;

    }

    //return true if all modules were built
    public boolean allModulesWereBuilt(String configuration, int[] modulesArray) {
        boolean allModules = true;

        int[] modulesValidate = new int[6];
        String[] fields = getEachConfiguration(configuration);
        try {
            for (int x = 0; x < fields.length; x++) {
                String[] values = getEachValue(fields[x].toString());
                String rowAll = values[0];
                int rowLocal = Integer.parseInt(String.valueOf(rowAll.charAt(1)));
                modulesValidate[rowLocal] = modulesValidate[rowLocal] + 1;
            }

            for (int x = 0; x < 5; x++) {
                if (!(modulesArray[x] == modulesValidate[x])) {
                    return allModules = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allModules;
    }

    //return true if all artefacts are correct and compound all modules
    public boolean areArtefactsCorrect(String configuration, int[] modulesArray) {
        boolean isConfigurationOk = true;
        String[] fields = getEachConfiguration(configuration);
        try {
            for (int x = 0; x < fields.length; x++) {
                String[] values = getEachValue(fields[x].toString());
                String valueAll = values[2];
                String value = String.valueOf(valueAll.charAt(1));

                if (!value.equals("C")) {
                    isConfigurationOk = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isConfigurationOk;
    }

    //return true if configuration is not inspect and
    public boolean areNotArtifactsInspect(String configuration, int[] modulesArray) {

        boolean isConfigurationOk = true;
        String[] fields = getEachConfiguration(configuration);
        try {
            for (int x = 0; x < fields.length; x++) {

                String[] values = getEachValue(fields[x].toString());
                String valueAll = values[2];
                String value = String.valueOf(valueAll.charAt(1));

                if (!(value.equals("W") || value.equals("G"))) {
                    isConfigurationOk = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isConfigurationOk;
    }

    public String setCharAt(String cadena, int indice, String caracter) {
        return cadena.substring(0, indice) + caracter + cadena.substring(indice + 1);
    }


    //return dimention of an array
    public int returnDimArray(String[] array) {
        int dim = 0;

        try {
            dim = array.length;

        } catch (Exception e) {
            dim = 0;
        }
        return dim;
    }

//generate randomly a vector which size is MAXVAL
    public int[] randomVectorGeneration(int MAXVAL) {

        java.util.Random r = new java.util.Random();

        int[] arrayReturn = new int[MAXVAL];

        Integer[] values = new Integer[MAXVAL];

        Integer[] result = new Integer[MAXVAL];

        int i = 0, j = 0, k = 0;

        while ((values[i++] = i) < MAXVAL);

        i = MAXVAL - 1;

        while (i >= 0) {

            j = r.nextInt(i + 1);

            k = values[i];
            values[i] = values[j];
            values[j] = k;

            arrayReturn[i] = result[i] = values[i--];

        }
        return arrayReturn;
    }

    public String inspectRandomArtifact(String configuration, int[] modulesInspect) {
        String[] fields = getEachConfiguration(configuration);
        String chainConfiguration = null;

        int modulesSize = modulesInspect.length;
        int fieldsSize = fields.length;

        try {

            for (int y = 0; y < modulesSize; y++) {

                int artefactByMod = modulesInspect[y];

                while ((artefactByMod > 0)) {

                    for (int x = 0; x < fieldsSize; x++) {

                        String[] values = getEachValue(fields[x].toString());
                        String rowAll = values[0];
                        String columnAll = values[1];
                        int row = Integer.valueOf(String.valueOf(rowAll.charAt(1)));

                        if (row == y) {
                            if (generateRandomBug(10)) {
                                String newValueField = rowAll + "," + columnAll + "," + "VB0";
                                System.out.println("nuevo valor: " + newValueField);
                                fields[x] = newValueField;
                            } else {
                                String newValueField = rowAll + "," + columnAll + "," + "VC0";
                                System.out.println("nuevo valor: " + newValueField);
                                fields[x] = newValueField;
                            }
                            artefactByMod = artefactByMod - 1;
                        }
                    }
                }
            }

            for (int z = 0; z < fields.length; z++) {
                if (chainConfiguration == null) {
                    chainConfiguration = fields[z];
                } else {
                    chainConfiguration = chainConfiguration + "/" + fields[z];
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return chainConfiguration;
    }

    //percorrer string para encontrar enteiro especifico
    public boolean goOverString(String chain, int value) {
        boolean exist = false;

        String numChain = Integer.toString(value);

        try {
            if (chain.isEmpty()) {
                return false;
            }

            for (int i = 0; i < chain.length(); i++) {
                if (chain.substring(i, i + 1).equals(numChain)) {
                    return true;
                }
            }
        } catch (Exception e) {
           return false;
        }

        return exist;

    }

     //return max Column Value used in indivual board
    public int maxColumnValue(String configuration) {
        int maxColumnValue = 0;
        String[] fields = getEachConfiguration(configuration);
        try {
            for (int x = 0; x < fields.length; x++) {
                String[] values = getEachValue(fields[x].toString());
                String valueAll = values[1];
                String value = String.valueOf(valueAll.charAt(1));
                if (Integer.parseInt(value)>maxColumnValue)
                {
                  maxColumnValue =Integer.parseInt(value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxColumnValue;
    }
}
