package ru.netology;

import com.codeborne.selenide.Condition;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.when;
import static ru.netology.DataGenerator.Registration.getRegisteredUser;


public class AuthTest {

    @BeforeEach
    void setUp() {
        open("http://0.0.0.0:9999");
    }


    @Test
    @DisplayName("Should successfully login with active registered user")
    void shouldSuccessfulLoginIfRegisteredActiveUser() {
        var registeredUser = getRegisteredUser("active");

        $("[data-test-id='login'] .input__control").val(registeredUser.getLogin());
        $("[data-test-id='password'] .input__control").val(registeredUser.getPassword());
        $(".button").click();
        $(withText("Личный кабинет")).shouldBe(Condition.visible);


        // TODO: добавить логику теста, в рамках которого будет выполнена попытка входа в личный кабинет с учётными
        //  данными зарегистрированного активного пользователя, для заполнения полей формы используйте
        //  пользователя registeredUser
    }

//    @Test
//    @DisplayName("Should get error message if login with not registered user")
//    void shouldGetErrorIfNotRegisteredUser() {
//        var notRegisteredUser = getUser("active");
//        // TODO: добавить логику теста в рамках которого будет выполнена попытка входа в личный кабинет
//        //  незарегистрированного пользователя, для заполнения полей формы используйте пользователя notRegisteredUser
//    }
//
//    @Test
//    @DisplayName("Should get error message if login with blocked registered user")
//    void shouldGetErrorIfBlockedUser() {
//        var blockedUser = getRegisteredUser("blocked");
//        // TODO: добавить логику теста в рамках которого будет выполнена попытка входа в личный кабинет,
//        //  заблокированного пользователя, для заполнения полей формы используйте пользователя blockedUser
//    }
//
//    @Test
//    @DisplayName("Should get error message if login with wrong login")
//    void shouldGetErrorIfWrongLogin() {
//        var registeredUser = getRegisteredUser("active");
//        var wrongLogin = getRandomLogin();
//        // TODO: добавить логику теста в рамках которого будет выполнена попытка входа в личный кабинет с неверным
//        //  логином, для заполнения поля формы "Логин" используйте переменную wrongLogin,
//        //  "Пароль" - пользователя registeredUser
//    }
//
//    @Test
//    @DisplayName("Should get error message if login with wrong password")
//    void shouldGetErrorIfWrongPassword() {
//        var registeredUser = getRegisteredUser("active");
//        var wrongPassword = getRandomPassword();
//        // TODO: добавить логику теста в рамках которого будет выполнена попытка входа в личный кабинет с неверным
//        //  паролем, для заполнения поля формы "Логин" используйте пользователя registeredUser,
//        //  "Пароль" - переменную wrongPassword
//    }

}
