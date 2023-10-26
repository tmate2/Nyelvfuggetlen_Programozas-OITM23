# Adat

Móricka egy olyan adatszerkezetet implementál, amely két műveletet tud:
- push_back(x), ahol x egy egész szám: x-et beszúrja a lista végére, x lesz az új utolsó elem (mint C++-ban az std::vector::push_back)
- pop_middle(): ha N elem van, akkor a floor(N/2) indexűt (0-tól számozzuk az elemeket!) eltávolítja, és ezzel az eltávolított értékkel tér vissza. Ha N=0: return 0.

Kész is lett a kóddal, és persze írt is hozzá teszteseteket is. Minden teszteset egy szövegfájl, melyben K db sor található. Mindegyik sor vagy egy egész szám (amit push_back-elni kell), vagy egy p betű, mely esetben a pop_middle kerül meghívásra.

Számoljuk ki, hogy az adott tesztesetre mennyi a pop_middle műveletek által visszaadott számok összege!
