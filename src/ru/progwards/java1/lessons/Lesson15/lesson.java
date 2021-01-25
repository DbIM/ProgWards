package ru.progwards.java1.lessons.Lesson15;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class lesson {
    // Реализуйте метод с сигнатурой HashMap<Integer, String> a2map(int[] akey, String[] aval),
    // который создает Map на основе пары массивов akey (ключи) и aval (значения).
    // Первому элементу массива akey соответствует первый элемент массива aval, и т.д.
    // Размеры массивов одинаковые.
    HashMap<Integer, String> a2map(int[] akey, String[] aval){
        HashMap<Integer, String> hashMap = new HashMap<>();
        for(int i = 0; i<akey.length; i++){
            hashMap.put(akey[i],aval[i]);
        }
        return hashMap;
    }

    // Создайте метод с сигнатурой int fillHoles(Map<Integer, String> map, int size),
    // который вставляет в HashMap пару <n> "Число n", если она там отсутствует,
    // Проверить от 1 до максимального числа size включительно.
    // Метод возвращает количество добавленных элементов. Пример пары: 1 "Число 1"
    int fillHoles(Map<Integer, String> map, int size){
        int x = 0;
        for(int i =1;i<=size; i++){
            String oldVal = map.putIfAbsent(i, "Число " + i);
            if (oldVal == null) x++;
        }
        return x;
    }

    void checkAndAdd(TreeMap<Integer, String> map, Integer key, String value){
            if (map.containsKey(key) || map == null || map.size() < 2) return;
            Integer first = map.firstKey();
            if (key < first) return;
            Integer last = map.lastKey();
            if (key > last) return;
            map.put(key, value);
    }

}


//Правильные ответы:
// Словари предназначены для быстрого поиска по ключу,
// Элементом словаря является пара ключ-значение (Map.Entry),
// Ключи уникальны, значения могут повторяться

//Правильный ответ:
// Найти и вернуть значение по ключу → V get(Object key),
// Добавить пару ключ-значение (Entry) → V put(K key, V value),
// Удалить Entry по ключу → V remove(Object key),
// Очистить словарь → void clear()

//Правильный ответ:
// Есть ли такой ключ? → boolean containsKey(Object key),
// Словарь пустой? → boolean isEmpty(),
// Есть ли такое значение? → boolean containsValue(Object value),
// Размер словаря (количество Entry) → int size()

//Правильный ответ:
// Коллекция значений → Collection<V> values(),
// Добавить все элементы из map m → void putAll(Map<? extends K,? extends V> m),
// Множество ключей → Set<K&gt keySet(),
// Множество элементов (Entry) → Set<Map.Entry<K,V>> entrySet()

//Правильные ответы:
// Классы HashMap, LinkedHashMap и Hashtable основаны на хеш-таблице,
// Хэш-словари имеют свойства capacity и loadFactor, влияющие на производительность и объём занимаемой памяти,
// Для эффективной работы хэш-словарей требуется хорошая хеш-функция для ключа

//Правильный ответ:
// Конструктор с указанием начального capacity и параметра loadFactor → HashMap(int initialCapacity, float loadFactor),
// Конструктор по умолчанию capacity = 16; loadFactor = 0.75 → HashMap(),
// Конструктор с указанием начального capacity; loadFactor = 0.75 → HashMap(int initialCapacity),
// Конструктор для создания HashMap на основе элементов другого словаря → HashMap(Map<? extends K, ? extends V> m)

//Правильный ответ:
//Добавить пару ключ-значение, если такого ключа нет в словаре;
// если добавление прошло успешно, то возвращает null, иначе - предыдущее значение в словаре → V putIfAbsent​(K key, V value),
// Удалить Entry по ключу и значению → boolean remove​(Object key, Object value),
// Заменить значение по ключу и значению (только если такая пара уже есть в словаре) → boolean replace​(K key, V oldValue, V newValue),
// Заменить значение по ключу (только если пара с таким ключом уже есть в словаре) → V replace​(K key, V value),
// Найти и вернуть значение по ключу или defaultValue, если не найден → V getOrDefault​(Object key, V defaultValue)

//Правильный ответ:
// Возвращает unmodifiable map, сформированный на основе пар (k1,  v1), (k2 - v2), ... → Map<K,V> Map.of(k1, v1, k2, v2, ...),
// Возвращает unmodifiable копию map → Map<K, V> Map.copyOf(Map<K, V> map),
// Возвращает unmodifiable entry → Entry<K, V> Map.entry(K k, V v)

//Правильные ответы:
// Класс TreeMap поддерживает сортировку элементов,
// Интерфейс SortedMap позволяет получить первый и последний ключи,
// Интерфейс NavigableMap позволяет осуществлять навигацию в словаре

//Правильный ответ:
// Конструктор по умолчанию: предполагается реализация Comparable в классе ключа → TreeMap(),
// Конструктор для создания TreeMap на основе элементов другого сортированного словаря: компаратор берётся из m
// → TreeMap(SortedMap<K, ? extends V> m),
// Конструктор с указанием компаратора → TreeMap(Comparator<? super K> comparator),
// Конструктор для создания TreeMap на основе элементов другого словаря: предполагается реализация Comparable в классе ключа
// → TreeMap(Map<? extends K, ? extends V> m)


//Правильный ответ:
// Возвращает голову словаря до toKey → SortedMap<K,V> headMap(K toKey),
// Возвращает компаратор или null → Comparator<? super K> comparator(),
// Возвращает последний ключ → K lastKey(), Возвращает хвост словаря от fromKey → SortedMap<K,V> tailMap(K fromKey),
//Возвращает часть отсортированного словаря от fromKey до toKey → SortedMap<K,V> subMap(K fromKey, K toKey),
// Возвращает первый ключ → K firstKey()

//Правильный ответ:
// Находит ближайший к key элемент из набора строго больших чем key → Map.Entry<K,V> higherEntry(K key),
// Находит ближайший к key элемент из набора строго меньших чем key → Map.Entry<K,V> lowerEntry(K key),
// Возвращает последний элемент и удаляет его из словаря → Map.Entry<K,V> pollLastEntry(),
// Возвращает первый элемент и удаляет его из словаря → Map.Entry<K,V> pollFirstEntry(),
// Находит ближайший к key элемент из набора больше или равных key → Map.Entry<K,V> ceilingEntry(K key),
// Возвращает словарь с обратной сортировкой → NavigableMap<K, V> descendingMap(),
// Находит ближайший к key элемент из набора меньше или равных key → Map.Entry<K,V> floorEntry(K key)