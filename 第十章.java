import code_list_two.*;
import code_list_three.A3;
import test.Factories;

public class 第十章 {
    /*
     * ·第十章：内部类
     * 	·将一个类的定义放在另一个类的内部，这就是内部类
     * 	·内部类是以一种非常有用的特征，它允许你将一些逻辑相关的类组织在一起，并控制内部类的可见性
     * 	·内部类了解外围类，并与之通信
     */

    /*
     * ·创建内部类
     * 	·在拥有外部类对象之前是不能创建该内部类对象的，因为内部类的创建必须要有一个外部类建立连接(就比如寄养生物，如果连寄主都没有，就不存在寄养生物了)
     */
    Parcell parcell;

    /*
     * ·链接到外部类
     * 	·当生成一个内部类对象时，此对象与制作它的外围对象之间还有一种联系，所以它能访问其外围对象的所有成员。内部类还拥有其外围类的所有元素的访问权限
     * 	·内部类是如何获取外围类的成员的?
     * 	  ·内部类的创建必须要与某个外围类相关联的情况下才能被创建(可以通过外围类的一个方法返回一个新建的内部类)，内部类不能被单独创建(除了在外围类之内)
     * 		当某个外围类对象创建了内部类时，此内部类就自动的获取了外围类的引用(编译器的事情)。当你在内部类要访问外围类的成员时，就会使用到这个引用
     * 		注意：在构建内部类对象时，需要一个指向外围类对象的引用，否则创建不了内部类
     */
    Sequence sequence;

    /*
     * ·使用.this与.new
     * 	·如果你需要在内部类生成对外部类对象的引用，可以使用外部类的名字后面紧跟圆点和this
     * 	·new关键字，通过外围类的对象.new  可以得到一个内部类的对象。
     * 		例如:Outer ou = new Outer();  Outer.Inner inn = ou.new Inner();
     */
    DotThis dotThis;//生成外围类的引用
    DotNew dotNew;//new关键字
    Parcel parcel;

    /*
     * ·嵌套类(静态内部类)，这样的类是不需要外部类的引用的
     */

    /*
     * ·内部类与向上转型
     * 	·内部类可以实现接口，并可以  向上转型  (转换为接口类型的)。等到的对象(内部类对象)可以指向基类或者接口的引用，所以可以很方便地隐藏实现的细节
     */
    TestParcel testParcel;

    /*
     * ·在方法和作用域内的内部类：在方法里面或者在任意的作用域内定义内部类
     * 	·这样做主要有：想创建一个类来辅助你解决方案，但是不希望这个类是公共可用的
     * 	·局部内部类：在方法的作用域内的创建一个完整的类
     */
    Parcel5 parcel5;//局部内部类：在方法里面定义的一个类
    Parcel6 parcel6;//这也是一个局部内部类，是定义在方法的if语块里面的

    /*
     * ·匿名内部类
     * 	·return new A() {} : 创建一个继承自A类(A可以是一个抽象类，具体类，或者是接口)的匿名类的对象
     * 	·如果你定义的内部类，这个内部类需要使用在外部定义的对象(通过参数传入)，那么编译器会要求引用是final
     * 	·
     */
    Parcel7 parcel7;//匿名类
    Parcel7b parcel7b;//跟上面的匿名类效果是一样的，只不过是展开写了
    Parcel9 parcel9;//匿名使用了在外部定义的对象(通过参数传入)，就要将参数定义为final(在方法签名那定义)
    AnonymousConstructor anonymousConstructor;//匿名类没有构造器，new A(i)[} 会将参数传递给基类的构造器

    /*
     * ·再访工厂方法
     */
    Factories fact;
    //单一的工厂模式
    ObjectO objectO;

    /*
     * ·嵌套类
     * 	·如果不需要内部类对象与外围类对象之间有联系，那么可以将内部类声明为static。这通常称为嵌套类
     * 	  ·嵌套意味着：1.创建嵌套类的对象，并不需要其外围类的对象  2.不能从嵌套类对象中访问非静态的外围类对象
     * 	·普通内部类不能有static字段和方法  也不能包含嵌套类，但是嵌套类可以包含这些东西。嵌套类也没有this引用(内部类使用外围类类名.this可以得到外围类的引用)
     *
     * 	·接口中的嵌套类
     * 	 ·如果你想创建某些公共代码，使它们可以被某个接口的所有不同实现所共用，那么使用接口内部的嵌套类会显示得很方便
     * 	 ·嵌套类可以成为接口中的一部分(该嵌套类还可以实现外围接口)。放在接口中的任何类都会成为public和static(所以在接口中定义嵌套类不用显式的声明为static)
     */
    Parcel11 parcel11;//嵌套类的定义
    ClassInInterface classInInterface;//接口中的嵌套类

    /*
     * 	·一个内部类被嵌套多少层不重要--它都能透明地访问所有它所嵌入的外围类的所有成员
     */
    MultiNestingAccess multiNestingAccess;

    /*
     * ·为什么使用内部类
     * 	·一般来说，内部类继承某个类或者实现某个接口，内部类的代码操作的是创建它外围类的对象。所以可以认为内部类提供了某种进入其外围类的窗口
     * 	·内部类非常灵活
     *    ·比如，外围类需要一个实例要实现某个接口的，但是外围类又不是总是需要这个接口，选择用外围类去实现这个接口的话并不是一种很好的选择
     * 	 这个时候选择用内部类去实现该接口   返回一个实现了某个接口的对象的话就会变得非常之灵活。
     * 	  ·又比如：必须在一个类中已某种方式实现两个接口。由于接口的灵活性，你有两种选择：使用单一的类去实现，或者使用内部类
     */
    MultiInterfaces multiInterfaces;//必须在一个类中已某种方式实现两个接口。由于接口的灵活性，你有两种选择：使用单一的类去实现，或者使用内部类

    /*
     * ·可以实现多重继承(需要继承的基类都是抽象的或者具体的，而不是接口)，那就只能使用内部类才能实现多重继承
     */
    MultiImplementation multiImplementation;

    /*
     * ·内部类的继承
     */
    InheritInner inheritInner;

    /*
     * ·局部内部类
     * 	·可以在代码块里创建内部类，典型的方式是在一个方法体的里面创建，局部内部类不能有访问修饰符，因为它不是外围类的一部分。但是它可以访问当前代码块的常量，以及外围类的所有
     */
    LocalInnerClass localInnerClass;

    /*
     * 练习
     */
    Outer outer;
    ObjectI objectI;
    Outer1 outer1;
    ObjectJ objectJ;
    A3 a3;
    ObjectK objectK;
    ObjectL objectL;
    ObjectM objectM;
    ObjectN objectN;
    ObjectQ objectQ;
    ObjectR objectR;
    ObjectS objectS;

}
