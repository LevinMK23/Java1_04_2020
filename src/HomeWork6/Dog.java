package HomeWork6;

public class Cat extends Animal implements AnimalMove {

    public Cat(){
        super(200,2.0f,0);
    }

    @Override
    public void run(int run) {

        if(super.getLimitRun()>=run){
            System.out.println("Кошка пробежала "+ run);
        }
        else {
            System.out.println("Кошка не может столько пробежать. Лимит:" + super.getLimitRun());
        }
    }

    @Override
    public void swim(int swim) {

        if(super.getLimitSwim()>=swim){
            System.out.println("Кошка проплыла "+ swim);
        }
        else {
            System.out.println("Кошка не может столько проплыть. Лимит:" + super.getLimitSwim());
        }

    }

    @Override
    public void jump(float jump) {

        if(super.getLimitJump()>=jump){
            System.out.println("Кошка прыгнула "+ jump);
        }
        else {
            System.out.println("Кошка не может на столько подпрыгнуть. Лимит:" + super.getLimitJump());
        }

    }
}
