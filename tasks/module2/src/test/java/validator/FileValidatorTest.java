package validator;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class FileValidatorTest {
    private ClassLoader classLoader = getClass().getClassLoader();
    FileValidator fileValidator = new FileValidator();

    @Test
    public void validateFileSuccess() {
        String path = new File(Objects.requireNonNull(classLoader.getResource("textExample.txt"))
                .getFile()).getAbsolutePath();
        ValidatorResult validatorResultSuccess = fileValidator.validateFile(path);
        ValidatorResult validatorResultExpends = new ValidatorResult();
        Assert.assertEquals(validatorResultSuccess.isValidate(), validatorResultExpends.isValidate());
    }

    @Test
    public void invalidFilePath() {
        ValidatorResult validatorResultSuccess = fileValidator.validateFile("InvalidPath.txt");
        ValidatorResult validatorResultExpends = new ValidatorResult();
        validatorResultExpends.addResult("File is no valid", "Nonexistent path to file");
        Assert.assertEquals(validatorResultSuccess.isValidate(), validatorResultExpends.isValidate());
    }

    @Test
    public void invalidFileFormat() {
        String path = new File(Objects.requireNonNull(classLoader.getResource("invalidFormat.java"))
                .getFile()).getAbsolutePath();
        ValidatorResult validatorResultSuccess = fileValidator.validateFile(path);
        ValidatorResult validatorResultExpends = new ValidatorResult();
        validatorResultExpends.addResult("File is no valid", "Incorrect file format");
        Assert.assertEquals(validatorResultSuccess.isValidate(), validatorResultExpends.isValidate());
    }

}