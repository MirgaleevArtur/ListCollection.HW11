public class Main {

    public static void main(String[] args) {
        String greetings = "Выберите операцию:";

        DealsManager toDoList = new DealsManager();

        while (true) {
            System.out.println(greetings);
            toDoList.printMenu();
            int userIntInput = UserInputReader.readIntValueFromConsole();

            switch (userIntInput) {

                case 0 -> {
                    toDoList.printDeals();
                    return;
                }

                case 1 -> {
                    System.out.println("Введите название задачи: ");
                    String userStringInput = UserInputReader.readStringValueFromConsole();
                    toDoList.addDeal(userStringInput);

                    toDoList.printDeals();
                }

                case 2 -> toDoList.printDeals();

                case 3 -> {
                    System.out.println("Введите номер задачи для удаления: ");
                    int dealNumber = UserInputReader.readIntValueFromConsole();
                    toDoList.removeDealByIndex(dealNumber);

                    toDoList.printDeals();
                }

                case 4 -> {
                    System.out.println("Введите точное название задачи для удаления: ");
                    String dealValue = UserInputReader.readStringValueFromConsole();
                    toDoList.removeDealByName(dealValue);

                    toDoList.printDeals();
                }

                case 5 -> {
                    System.out.println("Введите слово для поиска и удаления всех совпадений: ");
                    String keyword = UserInputReader.readStringValueFromConsole().toLowerCase();
                    toDoList.removeByKeyword(keyword);

                    toDoList.printDeals();
                }

                default -> System.out.println("Неизвестная команда, попробуйте еще раз.");
            }
        }
    }
}
