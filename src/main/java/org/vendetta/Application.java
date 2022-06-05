package org.vendetta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** ЗАДАЧИ
 * + Поднять приложение в докере
 * + Подключить БД postgres в докере
 * + Подключить автогенерацию ddl
 * - Добавить валидацию входящих данных
 * + Необходимо, чтобы использовалась конфигурация dev
 * + Необходимо, чтобы мавен собирал проект автоматически перед запуском докера (используя sh)
 * + Разобраться с правильным логированием
 * + Подключить git
 * + Отключить автогенерацию ddl и добавить миграции flyway и запускать их перед запуском приложения
 * - Добавить запуск тестов перед запуском программы maven fail safe plugin
 * - Создать все возможные связи с хибером (otm, oto, mto, mtm)
 * - Использовать все модули Spring
 * - Подключить кэширование
 * - Подключить брокер сообщений
 * - Подключить jenkins
 * - Создать тестовую нагрузку
 * - Попробовать Actuator, создать метрики
 * - Разобраться с артифакторием
 * - Добавить реактивное программирование
 * - Использовать искусственные потоки в 18 java
 * - Посмотреть что такое swarm
 * - Разобраться с Kubernetes
 * - Покрыть проект тестами на 100%
 * - Попробовать создать интересную боевую систему
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
