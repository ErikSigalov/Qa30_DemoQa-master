package manager;

import models.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StudentHelper extends HelperBase{
    public StudentHelper(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        if(isElementPresent(By.id("close-fixedban"))) {
            click(By.id("close-fixedban"));
        }
        click(By.xpath("//div[@class='category-cards']/div[2]"));
        pause(500);
    }

    public void selectPracticeForm() {
        click(By.xpath("//span[.='Practice Form']"));
    }
    public void uploadPicture() {
        wd.findElement(By.id("uploadPicture")).sendKeys("/Users/tayahatum/Qa30/Qa30_DemoQa/boy.jpeg");
    }
    public void submit() {
        click(By.id("submit"));
    }

    public void closeSuccessDialog() {
        click(By.id("closeLargeModal"));
    }

    public void fillForm(Student model) {

        type(By.id("firstName"),model.getFirstName());
        type(By.id("lastName"),model.getLastName());
        type(By.id("userEmail"),model.getEmail());
        selectGender(model.getGender());
        type(By.id("userNumber"),model.getPhone());
        //typeBDay(model.getBirthday());
        typeBDaySelect(model.getBirthday());

        //addSubjectByClick(model.getSubject());
        //selectHobby(model.getHobbies());
        type(By.id("currentAddress"), model.getAddress());
        //typeState(model.getState());
        //typeCity(model.getCity());
    }

    private void typeBDaySelect(String birthday) {
//25 5 1990
        click(By.id("dateOfBirthInput"));

        new Select(wd.findElement(By.cssSelector(".react-datepicker__month-select"))).selectByValue("4");
        new Select(wd.findElement(By.cssSelector(".react-datepicker__year-select"))).selectByValue("1990");

        // click data
        click(By.xpath("//div[text()='25']"));
        pause(6000);
    }









    private void typeBDay(String birthday) {
        WebElement dBirth = wd.findElement(By.id("dateOfBirthInput"));
        dBirth.click();
        String os = System.getProperty("os.name");
        System.out.println(os);

        if(os.startsWith("Mac")){
            //command +a
            dBirth.sendKeys(Keys.chord(Keys.COMMAND ,"a"));

        }else{
            //control+a
            dBirth.sendKeys(Keys.chord(Keys.CONTROL,"a"));

        }
        dBirth.sendKeys(birthday);
        dBirth.sendKeys(Keys.ENTER);


    }

    private void selectGender(String gender) {
        if(gender.equals("Male")) {
            click(By.xpath("//label[@for='gender-radio-1']"));
        }else if (gender.equals("Female")){
            click(By.xpath("//label[@for='gender-radio-2']"));
        }else {
            click(By.xpath("//label[@for='gender-radio-3']"));
        }
    }
}
