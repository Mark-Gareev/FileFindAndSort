# FileFindAndSort
ТЗ : 
1. Имеется корневая папка. В этой папке могут находиться текстовые файлы, а также другие папки. В других папках также могут находится текстовые файлы и папки (уровень вложенности может оказаться любым).Найти все текстовые файлы, отсортировать их по имени и склеить содержимое в один текстовый файл.

Задача решилась двумя классами. Один из них ищет файлы и обходит директорию, второй склеивает файлы в один. Сортировка по имени происходит внутри структуры treemap, в явном виде нигде не сортируется.
В метод concatenate нужно передать путь до желаемого текстового файла с результатом выполнения программы.
