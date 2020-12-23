package aboutInterface;

public class CorrectPerson {
    private Transport currentTransport;//1) любая переменная которая объявлена
    // как transport будет иметь ехать и останавливаться
    //ВАЖНО! мы здесь работаем с любым объектом который имплементирует Transport


    public void start(Transport transport) {//2)мы говорим
        // пользователь ты можешь ехать, но тебе может прийти любой транспорт (машина скейт велик и т.д.
        transport.start();//3) мы на транспорте можем ехать
        currentTransport = transport;//4)нам нужно его ЗАПОМНИТЬ,
        // ссылку на ИНТЕРФЕЙС а не конкретно его реализацию
    }

    public void stop() {//5) а также можем остановится аналогично start
        if (currentTransport != null) {//6) если ехали на чем то
            currentTransport.stop();//мы его останавливаем
            currentTransport = null;//мы его обнуляем
        }

    }
}

