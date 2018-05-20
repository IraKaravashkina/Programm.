public class App {
}
        import programm.dao.ContactDao;
        import programm.dao.impl.DBContactDao;
        import programm.services.ContactService;
        import programm.services.impl.FSContactServiceImpl;
        import programm.view.CmdLineService;
        import programm.view.imlp.CmdLineServiceImpl;
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