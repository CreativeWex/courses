# 1. Базовые основы и модель памяти

Thread, Runnable, Callable. Жизненный цикл потока, состояния потока,
daemon, interrupt, join, приоритеты

## 1.1. Поток как сущность

Конкурентность vs параллелизм, когда многопоточность реально полезна
(I/O bound, CPU bound, responsive UI / REST)

## 1.2. Примитивы синхронизации и проблемы

Java Memory Model: понятия visibility, reordering, happens-before,
что реально гарантирует synchronized, volatile, final‑поля.

---

# 2. Примитивы синхронизации и проблемы

## 2.1. Проблемы многопоточности

Race condition, critical section, thread safety, что такое shared mutable state и
как его минимизировать (immutability, ThreadLocal)

synchronized (методы/блоки), intrinsic locks, monitor, reentrancy,
проблемы coarse‑grained locking.

volatile: где помогает, где нет; почему не заменяет lock, типичные misuse‑паттерны

Классические проблемы: deadlock, livelock, starvation, priority inversion, false sharing и как их диагностировать
(thread dump, профилировщики).

---

# 3. java.util.concurrent: ядро

## 3.1. Executor framework
Executor, ExecutorService, ThreadPoolExecutor, ScheduledExecutorService, политика очередей и rejection.

## 3.2. Задачи
Runnable, Callable, Future, правильное завершение пула (shutdown, awaitTermination), обработка исключений в задачах.

## 3.3 Высокоуровневые синхронизационные примитивы:

ReentrantLock, ReadWriteLock, StampedLock — когда они лучше synchronized.
Координация: CountDownLatch, CyclicBarrier, Phaser, Semaphore, паттерны «ожидание N задач», «батчи».

---

# 4. Коллекции, атомики и обмен данными
Concurrent collections: ConcurrentHashMap, ConcurrentLinkedQueue/Deque, CopyOnWriteArrayList и их типичные use‑cases.

Blocking очереди: BlockingQueue, ArrayBlockingQueue, LinkedBlockingQueue, SynchronousQueue, DelayQueue — реализация producer–consumer, пайплайнов.

Atomics и CAS: AtomicInteger/Long/Reference, LongAdder, AtomicStampedReference, когда атомики лучше/хуже локов.

ThreadLocal: где оправдан, где приводит к memory leak (особенно в контейнерах/ThreadPool).

---

# 5. Асинхронность, параллелизм и современные подходы

## 5.1. CompletableFuture
цепочки, комбинирование, allOf/anyOf, обработка ошибок, кастомные executors; построение асинхронных пайплайнов.

## 5.2 Parallel Streams и ForkJoin

ForkJoinPool, work‑stealing, RecursiveTask, где имеет смысл и как не убить latency в проде.

Ограничения parallel streams в web‑сервисах, влияние на общий пул.

Structured concurrency (Project Loom/современные практики): идея «structured» задач, cancelation propagation, связь с observability.

---

# 6. Виртуальные потоки

---

# 7. Паттерны, дизайн и best practices

Producer–Consumer, Work Stealing, Thread Pool, Read–Write lock, async pipeline, fan‑out/fan‑in.

Тайм‑ауты, backpressure, circuit breaker (в привязке к конкаренси).