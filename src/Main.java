/*
Sa se creeze o aplicatie care contine un GUI in care ingredientele vor fi adaugate dintr-un textbox la apasarea
unui buton. La prima apasare a butonului se sterge baza de date cu ingrediente detinute si se adauga primul
ingredient. Dupa adaugarea tuturor ingredientelor, selectam butonul de Rand, la apasarea caruia dintr-o baza de
date cu retete ni se vor afisa 3 optiuni pe baza ingredientelor mentionate. Pentru fiecare reteta, vom avea o
imagine, ingredientele avute bifate, iar cele suplimentare(daca este cazul) cu x. Sub ingrediente se va gasi
timpul necesar realizarii si pasii pe care trebuie sa ii urmam
*/
public class Main {
    public static void main(String[] args) {
        StartFrame startframe = new StartFrame();
        startframe.setVisible(true);
    }
}