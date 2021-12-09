package classes;

public abstract class creatures {
    private int cid;
    private int age;
    private int birthDate;
    private char sex;

    public creatures(int cid,int actualDate, int age, char sex) {
        this.cid = cid;
        this.age = age;
        this.birthDate = actualDate - age;
        this.sex = sex;
    }

    public abstract void display();

    public void setAge(int age) {
        this.age = age;
    }

    public int getCid() {
        return cid;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }
}
