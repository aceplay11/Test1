    public class Singleton
    {
        // private makes access by only by getInstance() method
        private static Singleton instance;

        private Singleton() {
        }

        //synchronized method to control simultaneous access
        synchronized public static Singleton getInstance()
        {
            if (instance == null) {
                // if instance is null, create new singleton
                instance = new Singleton();
            }
            return instance;
        }
    }

