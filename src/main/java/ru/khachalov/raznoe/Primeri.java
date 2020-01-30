package ru.khachalov.raznoe;

public class Primeri {

    public static void copyArr(){
        int arr[] = new int[5];
        for (int i =0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*10);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int arr1[] = new int[5];
        System.arraycopy(arr,0, arr1,0,arr.length);
        for (int k = 0; k<arr1.length; k++){
            System.out.print(arr1[k] + " ");
        }
    }

    public static void primObj(){
        Primeri pri = new Primeri();
        System.out.println(pri + "test");
        boolean inst = pri instanceof Primeri;
        System.out.println(inst);
    }

    public static class Parent{

        public Parent(){
            test();
        }

        public void test(){
            System.out.println("parent::test");
        }

    }

    public static class Child extends Parent{

        private String field;

        public Child(){
            field = "abc";
        }

        public void test(){
            System.out.println("child::test");
            System.out.println("field="+field);
        }
    }



    public static void main(String[] args) {
//        copyArr();
//        primObj();
//        new Child();
//        try{
//            System.out.println(1);
//            throw  new Exception("a");
//        } catch (Exception ex){
//            System.out.println(ex.getMessage());
//        } finally {
//            System.out.println(2);
//        }
        int res = 13-15;
        int ult = 0;
        if (res!=0){
            ult = (int) (res/Math.abs(res));
        }
        System.out.println(ult);
    }
}
