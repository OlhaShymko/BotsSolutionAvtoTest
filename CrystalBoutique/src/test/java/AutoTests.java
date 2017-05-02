import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoTests {

        //���������� ���������� ���������� ����
        private String[] loginAutoriz; // ������ ������� ��� �����������
        private String[] passwordAutoriz; // ������ ������� ��� �����������
        private String[] emailReg; // ������ e-mails ��� ����������� ������ ������������
        private String[] firstname; // ������ ��� ���������� ���� "���" � ����� �����������
        private String[] lastname; // ������ ��� ���������� ���� "�������" � ����� �����������
        private String[] passwordReg; // ������ ��� ���������� ���� "������" � ����� �����������

        //���������� ������ ���� WebDriver
        WebDriver webDriver;

        //��������, ������� ����������� �� �����
        @Before
        // �������� � ����� setUp ������, ������� ����������� �� ���� ������
         public void setUp(){

            loginAutoriz =new String[] {"olha.shymko.91@gmail.com", " ", "olha.shymko.91@gmail.com", "olha.shymko.91@gmail.com"};
            passwordAutoriz =new String[] {"RQxmGUaa", " ", "123", "123456"};
            emailReg =new String[] {"olha.shy@gmail.com", "!#$~^:;-_+=@gmail.com", "olha@gmail.com", "1290.OoZzAa@gmail.com" , "()@gmail.com"};
            firstname = new String[] {"Olha"};
            lastname = new String[] {"Sh"};
            passwordReg = new String[] {"1234567"};

            // ������������� ChromeDriver
            webDriver = new ChromeDriver();
            // ����������� �������� �����
            webDriver.get("http://crystal-boutique.com.ua/");

            // ������� ������� ������ ����� �� �������� �����������/�������������
            webDriver.findElement(By.className("login"));
            webDriver.findElement(By.className("login")).click();
        }

    @Test
        public void testAuthorization(){
            //����������� ������������ �� �����
        for (int i = 0; i < loginAutoriz.length ; i++) {
            webDriver.findElement(By.id("email")).clear();
            webDriver.findElement(By.id("email")).sendKeys(loginAutoriz[i]);
            webDriver.findElement(By.id("passwd")).sendKeys(passwordAutoriz[i]);
            webDriver.findElement(By.id("SubmitLogin")).click();
            // ����� �� ����� �����������
            if(loginAutoriz[i].equals("olha.shymko.91@gmail.com") && passwordAutoriz[i].equals("RQxmGUaa")) {
             webDriver.findElement(By.className("logout")).click();
            }
        }
    }

    @Test
        public void testRegistration(){
            //����������� ������������ �� �����
        for (int j = 0; j < emailReg.length ; j++) {
            webDriver.findElement(By.id("email_create")).clear();
            webDriver.findElement(By.id("email_create")).sendKeys(emailReg[j]);
            webDriver.findElement(By.id("SubmitCreate")).click();
        }
        webDriver.findElement(By.id("customer_firstname")).click();
        webDriver.findElement(By.id("customer_firstname")).sendKeys(firstname[0]);
        webDriver.findElement(By.id("customer_lastname")).click();
        webDriver.findElement(By.id("customer_lastname")).sendKeys(lastname[0]);
        webDriver.findElement(By.id("passwd")).sendKeys(passwordReg[0]);
        webDriver.findElement(By.id("submitAccount")).click();
        webDriver.findElement(By.className("logout")).click();

    }
    @Test
        public void testByeGoods() {
        webDriver.findElement(By.id("email")).sendKeys(loginAutoriz[0]);
        webDriver.findElement(By.id("passwd")).sendKeys(passwordAutoriz[0]);
        webDriver.findElement(By.id("SubmitLogin")).click();
    }

    // ����������� ����� ������� �����. ����� ��������� �������
    @After
        public void tearDown(){
        if (webDriver != null)
        webDriver.close();
    }

}
