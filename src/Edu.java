import java.util.Scanner;

class NoSuchCountryException extends Exception {
    public NoSuchCountryException(String ruName) {
        super(ruName);
    }
}

enum Country {
    ENGLAND("Англия", true),
    POLAND("Англия", true),
    CROATIA("Хорватия", false),
    GERMANY("Германия", false),
    RUSSIA("Россия", true);
    private final String ruName;
    private final boolean isOpen;

    Country(String ruName, boolean isOpen) {
        this.ruName = ruName;
        this.isOpen = isOpen;
    }

    public static Country getByRuName(String ruNane) throws NoSuchCountryException {
        for (Country value : Country.values()) {
            if (value.ruName.equals(ruNane)) return value;
        }
        throw new NoSuchCountryException(ruNane);
    }

    @Override
    public String toString() {
        switch (this) {
            case ENGLAND:
                return ENGLAND.name() + "(" + ruName + ")";
            case POLAND:
                return POLAND.name() + "(" + ruName + ")";
            case CROATIA:
                return CROATIA.name() + "(" + ruName + ")";
            case GERMANY:
                return GERMANY.name() + "(" + ruName + ")";
            case RUSSIA:
                return RUSSIA.name() + "(" + ruName + ")";
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean isOpen() {
        return isOpen;
    }
}

public class Edu {
    public static void main(String[] args) {
        for (Country value : Country.values()) {
            System.out.print(value + " ");
        }
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        Country myCoutry = null;
        while (myCoutry == null) {
            String country = scanner.nextLine();
            try {
                myCoutry = Country.valueOf(country.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Наименование страны на английском введено некорректно, проверяем русское название");

            }
            try {
                myCoutry = Country.getByRuName(country);
            } catch (NoSuchCountryException e) {
                System.out.println("Страны " + country + " не существует");
            }
        }
        if (myCoutry.isOpen()) {
            System.out.println("Страна [" + myCoutry + "] открыта для посещения");
        } else {
            System.out.println("Страна [" + myCoutry + "] закрыта для посещения");
        }
    }
}