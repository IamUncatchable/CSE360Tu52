package fxMedicalCenter;

public enum RightBarImage {
    RIGHT_BAR_1("/rightBar1.jpg"),
    RIGHT_BAR_2("/rightBar2.jpg"),
    RIGHT_BAR_3("/rightBar3.jpg"),
    RIGHT_BAR_4("/rightBar4.jpg"),
    RIGHT_BAR_5("/rightBar5.jpg"),
    RIGHT_BAR_6("/rightBar6.jpg"),
    RIGHT_BAR_7("/rightBar7.jpg"),
    RIGHT_BAR_8("/rightBar8.jpg"),
    RIGHT_BAR_9("/rightBar9.jpg");

    private final String filePath;

    RightBarImage(String filePath) {
        this.filePath = filePath;
    }

    public String get() {
        return filePath;
    }
}