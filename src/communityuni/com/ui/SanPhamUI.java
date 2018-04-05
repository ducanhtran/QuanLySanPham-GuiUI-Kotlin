package communityuni.com.ui;
import javax.swing.*;
/**
 * Created by cafe on 04/06/2017.
 */
public class SanPhamUI extends JFrame {
    public SanPhamUI(String title)
    {
        super(title);
        setContentPane(new SanPhamPanel().getPnMain());
    }
    public void showWindow()
    {
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}