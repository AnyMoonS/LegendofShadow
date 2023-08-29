package anymoons.legendofshadow.player;

public class PlayerProperties {
    public static int ShadowHeart;
    public static int SoulHeart;

    public PlayerProperties()
    {
        ShadowHeart = 0;
        SoulHeart = 0;
    }

    public static int getShadowHeart() {
        return ShadowHeart;
    }

    public static int getSoulHeart() {
        return SoulHeart;
    }

    public static void addShadowHeart(int value) {
        ShadowHeart = ShadowHeart + value;
    }

    public static void addSoulHeart(int value) {
        SoulHeart = SoulHeart + value;
    }

    public static void delShadowHeart(int value) {
        ShadowHeart = ShadowHeart - value;
    }

    public static void delSoulHeart(int value) {
        SoulHeart = SoulHeart - value;
    }

}
