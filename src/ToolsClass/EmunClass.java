package ToolsClass;

public class EmunClass {
    public static void main(String[] args) {

        // 枚举类实例化
        Weekday day = Weekday.FRI;

        // 输出当前日期
        System.out.println(day.dayValue + "、Today is " + day + "（" + day.name + "）");

        // 枚举类可以应用在switch语句中
        switch (day){
            case MON:
            case TUE:
            case WED:
            case THU:
            case FRI:
                System.out.println(day.name + " Work at home!");
                break;
            case SAT:
            case SUN:
                System.out.println(day.name + " Work at office!");
                break;
        }

    }

    /**
     * 枚举类，一种特殊的类
     */
    enum Weekday {
        // 每一个枚举常量相当于调用‘构造函数’创建了全局唯一的 静态实例
        // public static final Weekday SUN = new Weekday();
        MON(1, "星期一"),
        TUE(2, "星期二"),
        WED(3, "星期三"),
        THU(4, "星期四"),
        FRI(5, "星期五"),
        SAT(6, "星期六"),
        SUN(0, "星期日");

        // 枚举类成员变量
        public int dayValue;
        public String name;

        // 枚举类构造方法
        Weekday(int i, String chinese) {
            dayValue = i;
            name = chinese;
        }
    }
}
