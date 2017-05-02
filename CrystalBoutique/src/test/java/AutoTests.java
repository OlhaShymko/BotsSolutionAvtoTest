import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoTests {

        //Объявление переменных ссылочного типа
        private String[] loginAutoriz; // массив логинов для авторизации
        private String[] passwordAutoriz; // массив паролей для авторизации
        private String[] emailReg; // массив e-mails для регистрации нового пользователя
        private String[] firstname; // массив для заполнения поля "Имя" в форме регистрации
        private String[] lastname; // массив для заполнения поля "Фамилия" в форме регистрации
        private String[] passwordReg; // массив для заполнения поля "Пароль" в форме регистрации

        //Объявдение ссылку типа WebDriver
        WebDriver webDriver;

        //Действия, которые выполняются до теста
        @Before
        // Передаем в метод setUp данные, которые повторяются во всех тестах
         public void setUp(){

            loginAutoriz =new String[] {"olha.shymko.91@gmail.com", " ", "olha.shymko.91@gmail.com", "olha.shymko.91@gmail.com"};
            passwordAutoriz =new String[] {"RQxmGUaa", " ", "123", "123456"};
            emailReg =new String[] {"olha.shy@gmail.com", "!#$~^:;-_+=@gmail.com", "olha@gmail.com", "1290.OoZzAa@gmail.com" , "()@gmail.com"};
            firstname = new String[] {"Olha"};
            lastname = new String[] {"Sh"};
            passwordReg = new String[] {"1234567"};

            // Инициализация ChromeDriver
            webDriver = new ChromeDriver();
            // Открывается страница сайта
            webDriver.get("http://crystal-boutique.com.ua/");

            // Находим элемент кнопки входа на страницу регистрации/автоматизации
            webDriver.findElement(By.className("login"));
            webDriver.findElement(By.className("login")).click();
        }

    @Test
        public void testAuthorization(){
            //Авторизация пользователя на сайте
        for (int i = 0; i < loginAutoriz.length ; i++) {
            webDriver.findElement(By.id("email")).clear();
            webDriver.findElement(By.id("email")).sendKeys(loginAutoriz[i]);
            webDriver.findElement(By.id("passwd")).sendKeys(passwordAutoriz[i]);
            webDriver.findElement(By.id("SubmitLogin")).click();
            // Выход из формы авторизации
            if(loginAutoriz[i].equals("olha.shymko.91@gmail.com") && passwordAutoriz[i].equals("RQxmGUaa")) {
             webDriver.findElement(By.className("logout")).click();
            }
        }
    }

    @Test
        public void testRegistration(){
            //Регистрация пользователя на сайте
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

    // объявляется после каждого теста. Метод закрывает браузер
    @After
        public void tearDown(){
        if (webDriver != null)
        webDriver.close();
    }

}
