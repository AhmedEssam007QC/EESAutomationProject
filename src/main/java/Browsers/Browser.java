package Browsers;

public enum Browser {
    chrome {
        @Override
        public AbstractDrivers getfactory() {
            return new chromeFactory();
        }
    },
    firefox {
        @Override
        public AbstractDrivers getfactory() {
            return new fireFoxFactory();
        }
    },
    edge {
        @Override
        public AbstractDrivers getfactory() {
            return new edgeFactory();
        }
    };
public abstract AbstractDrivers getfactory();
}
