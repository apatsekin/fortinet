public class MockDB {
    /*
    1. It's a good practice to mock DAO layer for unit tests of the service layer. Mockito is a popular library, which allows to easily mock all involved DAOs.
    Besides that, mocking through Mockito provides a set of methods to test the behavior of the service methods, while they access mock DAOs:
    number of invocations, sequence of invocations, verification of exceptions and so on.
     @Autowired components could be replaced with the mock objects.

    2. To test DAO layer one may use the same @Mock annotations but for connection classes. The alternative is to use separate DB-config for testing
    with in-memory DB: H2 in In-Memory mode:
    configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem");
    */
}
