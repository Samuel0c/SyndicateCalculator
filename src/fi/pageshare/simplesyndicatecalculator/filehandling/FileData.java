package fi.pageshare.simplesyndicatecalculator.filehandling;

import fi.pageshare.simplesyndicatecalculator.logic.*;

public class FileData {

    private FileHandler fh;
    private Syndicate syndicate;

    public FileData(FileHandler fh) {
        this.fh = fh;
        this.syndicate = new Syndicate();
    }

    public Syndicate syndicateWithFileData() {
        Product currentProduct = null;
        for (String line : fh.getFileContent()) {
            String[] splittedLine = line.split("\\|");
            if (line.endsWith("##")) {
                currentProduct = new Product(splittedLine[0].trim(),
                        Double.parseDouble(splittedLine[1].replaceAll("\\s", "").replace("##", "")));
                this.syndicate.addMember(currentProduct);
            } else {
                if (currentProduct != null) {
                    currentProduct.addRecipient(
                            new Recipient(splittedLine[0].trim(),
                                    splittedLine[1].replaceAll("\\s", "")),
                            Integer.parseInt(splittedLine[2].replaceAll("\\s", "")));

                }
            }
        }
        return this.syndicate;
    }

}
