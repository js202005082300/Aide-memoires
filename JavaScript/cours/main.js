class Ninja
{
    constructor(name = "Naruto")
    {
        this.name = name;
    }
}

class SuperNinja extends Ninja
{
    constructor(name = "Naruto", weapon = "shuriken")
    {
        super(name);
        this.weapon = weapon;
    }
}

let kakashi = new SuperNinja("Kakashi Hatake", "kunai");
document.write(kakashi.name + "<br>");
document.write(kakashi.weapon + "<br>");