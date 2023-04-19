import java.util.*;
class Lesson {
    private String type;
    private String day;
    private int time;
    private int capacity;
    private int price;
    private List<String> customers;
    private double rating;

    public Lesson(String type, String day, int time, int price) {
        this.type = type;
        this.day = day;
        this.time = time;
        this.price = price;
        capacity = 5;
        customers = new ArrayList<String>();
        rating = 0.0;
    }

    public String getType() {
        return type;
    }

    public String getDay() {
        return day;
    }

    public int getTime() {
        return time;
    }

    public int getPrice() {
        return price;
    }

    public boolean isFull() {
        return customers.size() >= capacity;
    }

    public boolean addCustomer(String customer) {
        if (isFull()) {
            return false;
        }
        customers.add(customer);
        return true;
    }

    public boolean removeCustomer(String customer) {
        if (customers.remove(customer)) {
            return true;
        }
        return false;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumCustomers() {
        return customers.size();
    }

    public int getCapacity() {
        return capacity;
    }
}

class Booking {
    private static int count = 0;
    private int id;
    private Lesson lesson;
    private String customer;

    public Booking(Lesson lesson, String customer) {
        id = ++count;
        this.lesson = lesson;
        this.customer = customer;
        lesson.addCustomer(customer);
    }

    public int getId() {
        return id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public String getCustomer() {
        return customer;
    }

    public void setLesson(Lesson lesson) {
        this.lesson.removeCustomer(customer);
        this.lesson = lesson;
        lesson.addCustomer(customer);
    }

    public void cancel() {
        lesson.removeCustomer(customer);
    }
}

class WeekendFitnessClub {
    private static Map<String, List<Lesson>> timetable = new HashMap<String, List<Lesson>>();
    private static List<Booking> bookings = new ArrayList<Booking>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeTimetable();
        while (true) {
            System.out.println("Welcome to the Weekend Fitness Club!");
            System.out.println("Please select an option:");
            System.out.println("1. Book a lesson");
            System.out.println("2. Change/cancel a booking");
            System.out.println("3. Attend a lesson");
            System.out.println("4. Monthly lesson report");
            System.out.println("5. Monthly champion fitness type report");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookLesson();
                    break;
                case 2:
                    changeCancelBooking();
                    break;
                case 3:
                    attendLesson();
                    break;
                case 4:
                    monthlyLessonReport();
                    break;
                case 5:
                    monthlyChampionReport();
                    break;
                case 6:
                    System.out.println("Thank you for using the Weekend Fitness Club software!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void initializeTimetable() {
        List<Lesson> mondayLessons = new ArrayList<Lesson>();
        mondayLessons.add(new Lesson("Yoga", "Monday", 9, 20));
        mondayLessons.add(new Lesson("Pilates", "Monday", 10, 20));
        mondayLessons.add(new Lesson("Boxing", "Monday", 11, 30));
        mondayLessons.add(new Lesson("Zumba", "Monday", 14, 15));
        mondayLessons.add(new Lesson("Spinning", "Monday", 15, 20));
        timetable.put("Monday", mondayLessons);

        List<Lesson> tuesdayLessons = new ArrayList<Lesson>();
        tuesdayLessons.add(new Lesson("Yoga", "Tuesday", 9, 20));
        tuesdayLessons.add(new Lesson("Pilates", "Tuesday", 10, 20));
        tuesdayLessons.add(new Lesson("Boxing", "Tuesday", 11, 30));
        tuesdayLessons.add(new Lesson("Zumba", "Tuesday", 14, 15));
        tuesdayLessons.add(new Lesson("Spinning", "Tuesday", 15, 20));
        timetable.put("Tuesday", tuesdayLessons);

        List<Lesson> wednesdayLessons = new ArrayList<Lesson>();
        wednesdayLessons.add(new Lesson("Yoga", "Wednesday", 9, 20));
        wednesdayLessons.add(new Lesson("Pilates", "Wednesday", 10, 20));
        wednesdayLessons.add(new Lesson("Boxing", "Wednesday", 11, 30));
        wednesdayLessons.add(new Lesson("Zumba", "Wednesday", 14, 15));
        wednesdayLessons.add(new Lesson("Spinning", "Wednesday", 15, 20));
        timetable.put("Wednesday", wednesdayLessons);

        List<Lesson> thursdayLessons = new ArrayList<Lesson>();
        thursdayLessons.add(new Lesson("Yoga", "Thursday", 9, 20));
        thursdayLessons.add(new Lesson("Pilates", "Thursday", 10, 20));
        thursdayLessons.add(new Lesson("Boxing", "Thursday", 11, 30));
        thursdayLessons.add(new Lesson("Zumba", "Thursday", 14, 15));
        thursdayLessons.add(new Lesson("Spinning", "Thursday", 15, 20));
        timetable.put("Thursday", thursdayLessons);

        List<Lesson> fridayLessons = new ArrayList<Lesson>();
        fridayLessons.add(new Lesson("Yoga", "Friday", 9, 20));
        fridayLessons.add(new Lesson("Pilates", "Friday", 10, 20));
        fridayLessons.add(new Lesson("Boxing", "Friday", 11, 30));
        fridayLessons.add(new Lesson("Zumba", "Friday", 14, 15));
        fridayLessons.add(new Lesson("Spinning", "Friday", 15, 20));
        timetable.put("Friday", fridayLessons);

        List<Lesson> saturdayLessons = new ArrayList<Lesson>();
        saturdayLessons.add(new Lesson("Yoga", "Saturday", 9, 20));
        saturdayLessons.add(new Lesson("Pilates", "Saturday", 10, 20));
        saturdayLessons.add(new Lesson("Boxing", "Saturday", 11, 30));
        saturdayLessons.add(new Lesson("Zumba", "Saturday", 14, 15));
        saturdayLessons.add(new Lesson("Spinning", "Saturday", 15, 20));
        timetable.put("Saturday", saturdayLessons);

        List<Lesson> sundayLessons = new ArrayList<Lesson>();
        sundayLessons.add(new Lesson("Yoga", "Sunday", 9, 20));
        sundayLessons.add(new Lesson("Pilates", "Sunday", 10, 20));
        sundayLessons.add(new Lesson("Boxing", "Sunday", 11, 30));
        sundayLessons.add(new Lesson("Zumba", "Sunday", 14, 15));
        sundayLessons.add(new Lesson("Spinning", "Sunday", 15, 20));
        timetable.put("Sunday", sundayLessons);
    }

    private static void bookLesson() {
        System.out.println("Please select the day of the lesson (Monday/Tuesday/Wednesday/Thursday/Friday/Saturday/Sunday):");
        String day = scanner.next();
        System.out.println("Please select the time of the lesson (9/10/11/14/15):");
        int time = scanner.nextInt();
        List<Lesson> lessons = timetable.get(day);
        if (lessons == null) {
            System.out.println("Invalid day. Please try again.");
            return;
        }
        Lesson lesson = null;
        for (Lesson l : lessons) {
            if (l.getTime() == time) {
                lesson = l;
                break;
            }
        }
        if (lesson == null) {
            System.out.println("Invalid time. Please try again.");
            return;
        }
        if (lesson.isFull()) {
            System.out.println("Sorry, this lesson is full. Please try another one.");
            return;
        }
        System.out.println("Please enter your name:");
        String name = scanner.next();
        Booking booking = new Booking(lesson, name);
        bookings.add(booking);
        System.out.println("Your booking has been successful! Your booking ID is " + booking.getId() + ".");
    }

    private static void changeCancelBooking() {
        System.out.println("Please enter your booking ID:");
        int id = scanner.nextInt();
        Booking booking = null;
        for (Booking b : bookings) {
            if (b.getId() == id) {
                booking = b;
                break;
            }
        }
        if (booking == null) {
            System.out.println("Invalid booking ID. Please try again.");
            return;
        }
        System.out.println("Please select an option:");
        System.out.println("1. Change lesson");
        System.out.println("2. Cancel booking");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                changeLesson(booking);
                break;
            case 2:
                cancelBooking(booking);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private static void changeLesson(Booking booking) {
        System.out.println("Please select the day of the lesson:");
        String day = scanner.next();
        System.out.println("Please select the time of the lesson:");
        int time = scanner.nextInt();
        List<Lesson> lessons = timetable.get(day);
        if (lessons == null) {
            System.out.println("Invalid day. Please try again.");
            return;
        }
        Lesson lesson = null;
        for (Lesson l : lessons) {
            if (l.getTime() == time) {
                lesson = l;
                break;
            }
        }
    }
    private static void cancelBooking(Booking booking) {
        bookings.remove(booking);
        booking.cancel();
        System.out.println("Booking " + booking.getId() + " has been cancelled.");
    }
    public static void attendLesson() {
        System.out.println("Please enter your booking ID:");
        int id = scanner.nextInt();
        System.out.println("Enter your name:");
        String customer = scanner.next();
        System.out.println("Enter the day of the lesson (Monday/Tuesday/Wednesday/Thursday/Friday/Saturday/Sunday):");
        String day = scanner.next();
        System.out.println("Please select the time of the lesson (9/10/11/14/15):");
        int time = scanner.nextInt();

        List<Lesson> lessons = timetable.get(day);
        Lesson lesson = null;
        for (Lesson l : lessons) {
            if (l.getTime() == time) {
                lesson = l;
                break;
            }
        }
        Booking booking = null;
        for (Booking b : bookings) {
            if (b.getId() == id) {
                booking = b;
                break;
            }
        }
        if (booking == null) {
            System.out.println("Invalid booking ID. Please try again.");
            return;
        }
        // Prompt the user to provide a review
        System.out.println("Please provide a review for the lesson:");
        Scanner scanner = new Scanner(System.in);
        String review = scanner.nextLine();

        // Prompt the user to provide a rating
        System.out.println("Please rate the lesson on a scale of 1 to 5 (5 being the highest rating):");
        int rating = scanner.nextInt();
        lesson.setRating(lesson.getRating() + rating);

        // Confirm that the review and rating were saved
        System.out.println("Thank you for your review and rating!");
    }
    private static void monthlyLessonReport() {
        System.out.println("Monthly Lesson Report:");
        System.out.println("----------------------");
        // Create a map to store the number of customers for each lesson type
        Map<String, Integer> lessonTypeCounts = new HashMap<String, Integer>();
        // Iterate over each lesson in the timetable
        for (List<Lesson> lessons : timetable.values()) {
            for (Lesson lesson : lessons) {
                // Get the lesson type
                String lessonType = lesson.getType();
                // If the lesson type is not already in the map, add it with a count of 0
                if (!lessonTypeCounts.containsKey(lessonType)) {
                    lessonTypeCounts.put(lessonType, 0);
                }
                // Add the number of customers for this lesson to the count for the lesson type
                lessonTypeCounts.put(lessonType, lessonTypeCounts.get(lessonType) + lesson.getNumCustomers());
            }
        }
        // Print the report
        for (String lessonType : lessonTypeCounts.keySet()) {
            System.out.println(lessonType + ": " + lessonTypeCounts.get(lessonType) + " customers");
        }
    }
    private static void monthlyChampionReport() {
        System.out.println("Monthly Champion Fitness Type Report:");
        System.out.println("-------------------------------------");
        // Create a map to store the total rating for each lesson type
        Map<String, Double> lessonTypeRatings = new HashMap<String, Double>();
        // Iterate over each lesson in the timetable
        for (List<Lesson> lessons : timetable.values()) {
            for (Lesson lesson : lessons) {
                // Get the lesson type
                String lessonType = lesson.getType();
                // If the lesson type is not already in the map, add it with a total rating of 0.0
                if (!lessonTypeRatings.containsKey(lessonType)) {
                    lessonTypeRatings.put(lessonType, 0.0);
                }
                // Add the lesson's rating to the total rating for the lesson type
                lessonTypeRatings.put(lessonType, lessonTypeRatings.get(lessonType) + lesson.getRating());
            }
        }
        // Find the lesson type with the highest average rating
        String championLessonType = null;
        double championLessonTypeRating = 0.0;
        for (String lessonType : lessonTypeRatings.keySet()) {
            double lessonTypeRating = lessonTypeRatings.get(lessonType);
            int numLessons = timetable.get("Monday").size() + timetable.get("Tuesday").size() +
                    timetable.get("Wednesday").size() + timetable.get("Thursday").size() +
                    timetable.get("Friday").size() + timetable.get("Saturday").size() +
                    timetable.get("Sunday").size();
            double avgRating = lessonTypeRating / numLessons;
            if (avgRating > championLessonTypeRating) {
                championLessonType = lessonType;
                championLessonTypeRating = avgRating;
            }
        }
        // Print the report
        System.out.println("Champion Fitness Type: " + championLessonType);
        System.out.println("Average Rating: " + championLessonTypeRating);
    }
}