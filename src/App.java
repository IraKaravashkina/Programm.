public class App {
}
        import dao.ContactDao;
        import dao.impl.DBContactDao;
        import services.ContactService;
        import services.impl.FSContactServiceImpl;
        import view.CmdLineService;
        import view.impl.CmdLineServiceImpl;
        import java.io.IOException;

public class App {

    /**

     * Начало программы. Тут запускается программа, создаются все сервиса и устанавливаются связи между ними.

     */

    public static void main(String[] args) throws IOException {
        ContactDao contactDao = new DBContactDao();
        ContactService contactService = new FSContactServiceImpl(contactDao);
        CmdLineService cmd = new CmdLineServiceImpl(contactService);
        cmd.runMenu();
    }
}
