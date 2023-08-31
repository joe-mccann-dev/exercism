abstract class Fighter {

  boolean isVulnerable() {
    return false;
  }

  @Override
  public String toString() {
    return "Fighter is a " + this.getClass().getSimpleName();
  }

  abstract int damagePoints(Fighter fighter);
}

class Warrior extends Fighter {

  @Override
  int damagePoints(Fighter wizard) {
    int dmgFighterVulnerable = 10;
    int dmgFighterNotVulnerable = 6;

    return wizard.isVulnerable() ? dmgFighterVulnerable : dmgFighterNotVulnerable;
  }
}

class Wizard extends Fighter {
  private boolean spellPrepared = false;

  @Override
  boolean isVulnerable() {
    return !getSpellPrepared();
  }

  @Override
  int damagePoints(Fighter warrior) {
    int dmgSpellPrepared = 12;
    int dmgSpellNotPrepared = 3;

    return getSpellPrepared() ? dmgSpellPrepared : dmgSpellNotPrepared;
  }

  void prepareSpell() {
    setSpellPrepared(true);
  }

  boolean getSpellPrepared() {
    return spellPrepared;
  }

  void setSpellPrepared(boolean prepared) {
    this.spellPrepared = prepared;
  }

}
