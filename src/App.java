import com.kesunorin.ui.GameJFrame;
import com.kesunorin.ui.LoginJFrame;
import com.kesunorin.ui.RegisterJFrame;

public class App {
    public static void main(String[] args) {
        //主程序入口
        new LoginJFrame();

        new GameJFrame();

        new RegisterJFrame();
    }
}
