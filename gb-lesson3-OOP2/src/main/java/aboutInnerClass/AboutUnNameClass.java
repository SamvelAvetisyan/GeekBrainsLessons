package aboutInnerClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUnNameClass {
    public static void main(String[] args) {
        JButton button4 = new JButton("444");//1)кнопка
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(4);

            }
        });//2)для нажатии кнопки мы должны в addActionListener() передать как параметр
    //объект класса который имплементирует интерфейс ActionListener
        // или создать АНОНИМНЫЙ внутренний КЛАСС как и мы сделали.
        //ТО есть мы создали объект типа интерфейса но его создавать нельзя
       // Потому и создали внутренний анонимный класс
        //3) По сути здесь создавался public class AboutUnNameClass$1(он взял имя внешнего класса
        //$1 потому что первый, здесь производится implements ActionListener
        // и внутри переопределяется метод actionPerformed() интерфейса ActionListener
        //4) public class AboutUnNameClass$1 implements ActionListener {
        // @Override
        //            public void actionPerformed(ActionEvent e) {
        //                System.out.println(4);
        //
        //            }
        //     }//5) и сразу же создавался объект
        //AboutUnNameClass$1 o = new AboutUnNameClass$1();
       // button4.addActionListener(o);

        //6)можем использовать лямбда вместе внутренного анонимного класса
        button4.addActionListener(e -> System.out.println(4));

    }


}

