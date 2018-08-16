import javax.swing.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI {
    //создание объектов
    JFrame frame;
    JPanel panel;
    JButton sendButton; //кнопка отправить
    JTextArea incoming; //то что приходит
    JTextField outgoing; //то что отправляем
    JScrollPane scrollerWest;
    JTextArea chatList; //список участников
    JTextArea chatChangesUser; //изменение участников чата
    ArrayList<JCheckBox> checkboxList;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    public void go() {
        //инициализация
        frame = new JFrame("Friendly chat");
        panel = new JPanel();
        panel.setLayout(null);

        //настройка кнопки
        sendButton = new JButton("Send");
        sendButton.setBounds(333,532,150,30);

        //настройка входящих
        incoming = new JTextArea();
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        incoming.setBounds(5,5,325,522);

        //настройка листа чата
        chatList = new JTextArea();
        chatList.setLineWrap(true);
        chatList.setWrapStyleWord(true);
        chatList.setEditable(false);
        chatList.setBounds(335,5,145,300);

        //настройка листа с изменением списка чата
        chatChangesUser = new JTextArea();
        chatChangesUser.setLineWrap(true);
        chatChangesUser.setWrapStyleWord(true);
        chatChangesUser.setEditable(false);
        chatChangesUser.setBounds(335,310,145,217);

        //настройка исходящих
        outgoing = new JTextField();
        outgoing.setBounds(5,532,328,30);

        //скроллер и его настройка
        scrollerWest = new JScrollPane(incoming);
        scrollerWest.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollerWest.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );

        //оформление фрейма
        panel.add (scrollerWest);
        panel.add (incoming);
        panel.add (chatList);
        panel.add (chatChangesUser);
        panel.add (sendButton);
        panel.add (outgoing);

        //размеры фрейма
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
