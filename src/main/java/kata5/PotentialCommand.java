package kata5;

public class PotentialCommand implements Command{
    @Override
    public Output execute(Input input) {
        try{
            int number = Integer.parseInt(input.get(":number"));
            return isOutOfBound(number) ? outOfBoundOutput() : outputOf(number);

        } catch (NumberFormatException e) {
            return nanOutput();
        }
    }

    private Output nanOutput() {
        return new Output() {
            @Override
            public int responseCode() {
                return 405;
            }

            @Override
            public String result() {
                return "Not a number";
            }
        };
    }

    private Output outputOf(int number) {
        return new Output() {
            @Override
            public int responseCode() {
                return 200;
            }

            @Override
            public String result() {
                return String.valueOf(potentialOf(number));
            }
        };
    }

    private int potentialOf(int number) {
        return number*number;
    }

    private Output outOfBoundOutput() {
        return  new Output() {
            @Override
            public int responseCode() {
                return 404;
            }

            @Override
            public String result() {
                return "Number out of bound";
            }
        };

    }

    private boolean isOutOfBound(int number) {
        return number>1000000;
    }
}
