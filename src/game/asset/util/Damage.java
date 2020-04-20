package game.asset.util;

public class Damage {
    private double base;
    private double criticalChance;
    private double criticalDamage;
    private boolean critical;

    public Damage(double base, double criticalChance, double criticalDamage) {
        setBase(base);
        setCriticalChance(criticalChance);
        setCriticalDamage(criticalDamage);
    }

    public Damage(double base, boolean critical) {
        setBase(base);
        setCritical(critical);
    }

    /* GETTER */
    public final double base() { return base; }
    public final double criticalChance() { return criticalChance; }
    public final double criticalDamage() { return criticalDamage; }
    public final boolean critical() { return critical; }

    /* SETTER */
    public final void setBase(double base) { this.base = base; }
    public final void setCriticalChance(double criticalChance) { this.criticalChance = criticalChance; }
    public final void setCriticalDamage(double criticalDamage) { this.criticalDamage = criticalDamage; }
    public final void setCritical(boolean critical) { this.critical = critical; }
}
