package tests;

import models.Student;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentFormTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        app.studentHelper().selectItemForms();
        app.studentHelper().selectPracticeForm();
        app.studentHelper().hideFooter();

    }

    @Test
    public void studentFormTest(){
        Student model = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@mail.com")
                .gender("Male")
                .phone("1234567890")
                .birthday("25 5 1990")
                .subject("Maths")
                .hobbies("Sport")
                .address("Tel Aviv")
                .state("NCR")
                .city("Gurgaon")
                .build();
        app.studentHelper().fillForm(model);

        app.studentHelper().uploadPicture();

        app.studentHelper().pause(500);
        app.studentHelper().submit();
        app.studentHelper().pause(1000);
        //Assert.assertEquals(app.studentHelper().getTitleFromDialog(),"Thanks for submitting the form");
        app.studentHelper().closeSuccessDialog();

    }

}
