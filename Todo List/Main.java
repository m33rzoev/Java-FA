import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<Tasks> z = new ArrayList<>();
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Что Вы хотели бы сделать?");
            String o = sc.nextLine();
            if (Objects.equals(o, "new")){
                Show.add(z);
            } else if (Objects.equals(o, "all")) {
                Show.print(z, "None");
            } else if (Objects.equals(o, "all active")) {
                Show.print(z, "active");
            } else if (Objects.equals(o, "all done")) {
                Show.print(z, "done");
            } else if (Objects.equals(o, "del")) {
                Show.delete(z);
            } else if (Objects.equals(o, "edit")) {
                Show.edit(z);
            } else if (Objects.equals(o, "all date to")){
                Show.print_date_to(z, "None");
            } else if (Objects.equals(o, "all active date to")){
                Show.print_date_to(z, "active");
            } else if (Objects.equals(o, "all done date to")){
                Show.print_date_to(z, "done");
            } else if (Objects.equals(o, "all date create")){
                Show.print_date_create(z, "None");
            } else if (Objects.equals(o, "all active date create")) {
                Show.print_date_create(z, "active");
            } else if (Objects.equals(o, "all done date create")) {
                Show.print_date_create(z, "done");
            } else if (Objects.equals(o, "open")){
                Show.open(z);
            } else if (Objects.equals(o, "done")){
                Show.done(z);
            }
        }
    }
}

class Tasks{
    int number;
    String name;
    String desc;
    LocalDate date_create;
    LocalDate date_to;
    String status;
    public Tasks(String name, String desc, LocalDate to, int number){
        this.name = name;
        this.desc = desc;
        this.date_create = LocalDate.now();
        this.date_to = to;
        this.number = number;
        this.status = "active";
    }

    public void print(){
        System.out.println(this.name);
        System.out.println(this.desc);
    }
}

class Show{
    public static void add(List<Tasks> z){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название задачи:");
        String name = sc.nextLine();
        System.out.println("Введите описание задачи:");
        String desc = sc.nextLine();
        System.out.println("Введите дату окончания задачи (в формате 'День Месяц Год':");
        LocalDate to = add_date(sc.nextLine());
        Tasks z1 = new Tasks(name, desc, to, z.size() + 1);
        z.add(z1);
    }

    public static void delete(List<Tasks> z){
        Scanner sc = new Scanner(System.in);
        System.out.println("Какое задание Вы хотели бы удалить? (Введите его номер)");
        int number = sc.nextInt();
        z.remove(number - 1);
        for (int i = number - 1; i < z.size(); i ++){
            z.get(i).number = i + 1;
        }
    }

    public static LocalDate add_date(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static void print(List<Tasks> z, String status){
        if (z.size() > 0){
            for (Tasks z1 : z){
                if (Objects.equals(status, "None")){
                    System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);
                } else {
                    if (Objects.equals(z1.status, status)){
                        System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);
                    }
                }
            }
        } else {
            System.out.println("Задач ещё нет");
        }
    }

    public static void edit(List<Tasks> z){
        Scanner sc = new Scanner(System.in);
        System.out.println("Какое задание Вы хотели бы оредактировать?");
        int number = sc.nextInt() - 1;
        System.out.println("Что Вы хотели бы отредактировать?\n1 - Название\n2 - Описание\n3 - Дату выполнения");
        int o = sc.nextInt();
        sc = new Scanner(System.in);
        if (o == 1){
            System.out.println("Введите новое название задания:");
            z.get(number).name = sc.nextLine();
        } else if (o == 2) {
            System.out.println("Введите новое описания задания:");
            z.get(number).desc = sc.nextLine();
        } else if (o == 3) {
            System.out.println("Введите новую дату выполнения задания (в формате 'день месяц год'):");
            z.get(number).date_to = add_date(sc.nextLine());
        }
    }

    public static void print_date_create(List<Tasks> z, String status){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату создания задачи (в формате 'день месяц год')");
        LocalDate date = add_date(sc.nextLine());
        if (z.size() > 0){
            for (Tasks z1 : z){
                if (z1.date_create.isEqual(date)) {
                    if (Objects.equals(status, "None")) {
                        System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);
                    } else {
                        if (Objects.equals(z1.status, status)){
                            System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);
                        }
                    }
                }
            }
        } else {
            System.out.println("Задач ещё нет");
        }
    }

    public static void print_date_to(List<Tasks> z, String status){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дату выполнения задачи (в формате 'день месяц год')");
        LocalDate date = add_date(sc.nextLine());
        if (z.size() > 0){
            for (Tasks z1 : z){
                if (z1.date_to.isEqual(date)) {
                    if (Objects.equals(status, "None")) {
                        System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);
                    } else {
                        if (Objects.equals(z1.status, status)){
                            System.out.println(z1.number + ". " + z1.name + " до " + z1.date_to);
                        }
                    }
                }
            }
        } else {
            System.out.println("Задач ещё нет");
        }
    }

    public static void done(List<Tasks> z){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выполненное задание (номер):");
        int number = sc.nextInt() - 1;
        z.get(number).status = "done";
    }

    public static void open(List<Tasks> z){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер задания:");
        int number = sc.nextInt() - 1;
        System.out.println("Номер: " + z.get(number).number);
        System.out.println("Название: " + z.get(number).name);
        System.out.println("Описание: " + z.get(number).desc);
        System.out.println("Выполнить до " + z.get(number).date_to);
        System.out.println("Задание создано " + z.get(number).date_create);
        if (Objects.equals(z.get(number).status, "done")){
            System.out.println("Задание выполненно!");
        }
    }
}