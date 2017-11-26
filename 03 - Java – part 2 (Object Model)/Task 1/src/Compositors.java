public enum Compositors {
    BAH,
    BETHOVEN,
    PAGANINI,
    SHOPEN,
    MOZART;

    public static Compositors getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
