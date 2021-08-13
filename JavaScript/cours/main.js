function assert(condition, message)
{
    if(!condition)
        throw message || "Erreur d'assertion";
}
assert(1 === 2);