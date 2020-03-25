package ru.khachalov.yandexless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Cooking {
    public static int summ = 0;

    public static String inputLine(){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        return line;
    }

    public static List inputDishes(){
        int countDish = Integer.parseInt(inputLine());
        List<Dishes> dishes= new ArrayList<>();
        for (int i = 0; i < countDish; i++){
            String[] pars = inputLine().split(" ");
            dishes.add(new Dishes());
            dishes.get(i).setName(pars[0]);
            dishes.get(i).setCountDish(Integer.parseInt(pars[1]));
            for (int j = 0; j < Integer.parseInt(pars[2]); j++){
                String[] parsIngr = inputLine().split(" ");
                dishes.get(i).setIngr(new PriceCatalog(parsIngr[0], Integer.parseInt(parsIngr[1]), 0, parsIngr[2]));
            }
        }
        return dishes;
    }

    public static HashMap inputPrices(){
        HashMap<Integer, PriceCatalog> prices = new HashMap();
        int countPr = Integer.parseInt(inputLine());
        for (int i = 0; i < countPr; i++){
            String[] parsPr = inputLine().split(" ");
            prices.put(parsPr[0].hashCode(),
                    new PriceCatalog(parsPr[0], Integer.parseInt(parsPr[1]), Integer.parseInt(parsPr[2]), parsPr[3]));
        }
        return prices;
    }

    public static HashMap inputFoods(){
        HashMap<Integer, FoodCatalog> foods = new HashMap();
        int countF = Integer.parseInt(inputLine());
        for (int i = 0; i < countF; i++){
            String[] parsF = inputLine().split(" ");
            foods.put(parsF[0].hashCode(),
                    new FoodCatalog(parsF[0], Integer.parseInt(parsF[1]), parsF[2],
                            Integer.parseInt(parsF[3]), Integer.parseInt(parsF[4]),
                            Integer.parseInt(parsF[5]), Integer.parseInt(parsF[6])));
        }
        return foods;
    }

    public static HashMap countingIngr(){
        HashMap<Integer, PriceCatalog> allIngr = new HashMap<>();
        List<Dishes> d = inputDishes();
        HashMap<Integer,PriceCatalog> pc = inputPrices();
        for (int i = 0; i < d.size(); i++){
            List<PriceCatalog> di = d.get(i).getIngr();
            for (int j=0; j<di.size(); j++){
                    if (di.get(j).getU().equals("kg")){
                        di.get(j).setU("g");
                        di.get(j).setA(di.get(j).getA()*1000*d.get(i).getCountDish());
                    } else if (di.get(j).getU().equals("l")) {
                        di.get(j).setU("ml");
                        di.get(j).setA(di.get(j).getA() * 1000 * d.get(i).getCountDish());
                    } else if(di.get(j).getU().equals("tens")) {
                        di.get(j).setU("cnt");
                        di.get(j).setA(di.get(j).getA() * 10 * d.get(i).getCountDish());
                    }
                if (!allIngr.containsKey(di.get(j).getT().hashCode())){
                    PriceCatalog pr = new PriceCatalog(di.get(j).getT(), 0, di.get(j).getA(), di.get(j).getU());
                    allIngr.put(di.get(j).getT().hashCode(), pr);
                } else {
                    PriceCatalog pr = allIngr.get(di.get(j).getT().hashCode());
                    pr.setA(di.get(j).getA() + pr.getA());
                }
                for (HashMap.Entry entry: allIngr.entrySet()){
                    PriceCatalog temp = (PriceCatalog) entry;
                    if(!pc.get(entry.getKey()).getU().equals(temp.getU())){
                        if (pc.get(entry.getKey()).getU().equals("kg")){
                            temp.setA(temp.getA()*1000);
                            temp.setU("g");
                        } else if (pc.get(entry.getKey()).getU().equals("g")){
                            temp.setA(temp.getA()/1000);
                            temp.setU("kg");
                        } else if (pc.get(entry.getKey()).getU().equals("l")){
                            temp.setA(temp.getA()*1000);
                            temp.setU("ml");
                        } else if (pc.get(entry.getKey()).getU().equals("ml")){
                            temp.setA(temp.getA()/1000);
                            temp.setU("l");
                        } else if (pc.get(entry.getKey()).getU().equals("tens")){
                            temp.setA(temp.getA()*10);
                            temp.setU("cnt");
                        } else if (pc.get(entry.getKey()).getU().equals("cnt")){
                            temp.setA(temp.getA()/10);
                            temp.setU("tens");
                        }
                    }
                    int od = temp.getA()%pc.get(entry.getKey()).getA();
                    if (od == 0){
                        temp.setA(temp.getA()/pc.get(entry.getKey()).getA());
                    } else {
                        int cp = ((int) temp.getA()/pc.get(entry.getKey()).getA()) + 1;
                        temp.setA(cp);
                    }
                    summ += temp.getA()*pc.get(entry.getKey()).getP();
                }
            }
        }
        return  allIngr;
    }

    public static List countingFoods(){
        HashMap<Integer, FoodCatalog> fc = inputFoods();
        List<FoodCatalog> allFoods = new ArrayList<>();
        List<Dishes> d = inputDishes();
        double pr = 0,f=0,ch=0,fv=0;
        for (int i = 0; i < d.size(); i++){
            List<PriceCatalog> di = d.get(i).getIngr();
            for (int j=0; j<di.size(); j++) {
                double tempPr = fc.get(di.get(j).getT().hashCode()).getPr()*
                        (di.get(j).getA()/fc.get(di.get(j).getT().hashCode()).getA());
                double tempF = fc.get(di.get(j).getT().hashCode()).getF()*
                        (di.get(j).getA()/fc.get(di.get(j).getT().hashCode()).getA());
                double tempCh = fc.get(di.get(j).getT().hashCode()).getCh()*
                        (di.get(j).getA()/fc.get(di.get(j).getT().hashCode()).getA());
                double tempFv = fc.get(di.get(j).getT().hashCode()).getFv()*
                        (di.get(j).getA()/fc.get(di.get(j).getT().hashCode()).getA());
                if (di.get(j).getU().equals(fc.get(di.get(j).getT().hashCode()).getU())){
                    pr += tempPr;
                    f += tempF;
                    ch += tempCh;
                    fv += tempFv;
                } else if (di.get(j).getU().equals("ml")||di.get(j).getU().equals("g")){
                    pr += tempPr/1000;
                    f += tempF/1000;
                    ch += tempCh/1000;
                    fv += tempFv/1000;
                } else if (di.get(j).getU().equals("cnt")){
                    pr += tempPr/10;
                    f += tempF/10;
                    ch += tempCh/10;
                    fv += tempFv/10;
                } else if (di.get(j).getU().equals("l")||di.get(j).getU().equals("kg")){
                    pr += tempPr*1000;
                    f += tempF*1000;
                    ch += tempCh*1000;
                    fv += tempFv*1000;
                } else {
                    pr += tempPr*10;
                    f += tempF*10;
                    ch += tempCh*10;
                    fv += tempFv*10;
                }
            }
            allFoods.add(new FoodCatalog(d.get(i).getName(), 0, "n", pr, f, ch, fv));
        }
        return allFoods;
    }

    public static void main(String[] args) {
        HashMap<Integer, PriceCatalog> tempIng = countingIngr();
        System.out.println(summ);
        for (HashMap.Entry entry: tempIng.entrySet()){
            PriceCatalog temp = (PriceCatalog) entry;
            System.out.println(temp.getT() + " " + temp.getA());
        }
        List<FoodCatalog> tempFoods = countingFoods();
        for (int i = 0; i < tempFoods.size(); i++){
            System.out.println(tempFoods.get(i).getT() + " " + tempFoods.get(i).getPr() + " " +
                    tempFoods.get(i).getF() + " " + tempFoods.get(i).getCh() + " " + tempFoods.get(i).getFv());
        }
    }
}
