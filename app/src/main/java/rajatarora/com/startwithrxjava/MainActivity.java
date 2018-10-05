package rajatarora.com.startwithrxjava;

import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class MainActivity extends AppCompatActivity {

    List<String> namesArray = Arrays.asList("Rajat", "Arora", "Achal", "Arora",
            "Raj", "OM", "Rajat", "Shubham");
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    boolean transitionHappened = false;
    int startCount = 0;
    int finalCount = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        transitionCode();


//        observablesWithEmitter();

//        observablesWithMap();

//        observableWithFilter();

//        observableWithIterable();

//        connectableObservables();

//        observablesWithRange();

//        singleExample();

//        extractFirstElementWithDefaultValue();

//        maybeExample();

//        extractFirstElement();

//        completableExample();

//        subscribeWithExample();

//        takeExample();

//        takeLastExample();

//        skipExample();

//        skipLastExample();

//        takeWhileExample();

//        skipWhileExample();

//        distinctExample();

//        distinctUntilChanged();

//        elementAtExample();

//        elementAtOrErrorExample();

        deferExample();

        /// Transform Operators

//        mapExample();

//        castExample();

//        startWithExample();

//        startWithArrayExample();

//        defaultIsEmptyExample();

//        switchIfEmptyExample();

//        sortedExample();

//        delayExample();

//        repeatExample();

//        scanExample();

        /// Reduce Operators
//      You will likely have moments where you want to take a series of emissions and consolidate
//      them into a single emission (usually emitted through a Single)

//        countExample();

//        reduceExample();

//        allExample();

//        anyExample();

//        containsExample();

        /// Collection Operator
        // Collection operators will accumulate all emissions into a collection such as a list or
        // map and then emit that entire collection as a single emission.

//        toListExample();

//        toSortedListExample();

//        toMapExample();

//        toMultiMapExample();

//        collectExample();

        /// Error Recocvery Operators

//        onErrorReturnExample();

//        onErrorReturnItemExample();

//        onErrorResumeExample();

//        retryExample();

        /// Combining Observables

//        mergeExample();

//        mergeArrayExample();

//        flatMapExample();

//        concatExample();
//
//        concatMapExample();

//        zipExample();

//        groupByObservableExample();


        /// Multicasting

//        publishExample(); // converting a cold observable to hot

//        autoConnectExample();

//        refCountExample();

//        replayExample();

//        cacheExample();

//        publishSubjectExample();

//        behaviourSubjectExample();

        /// Concurrency and Parallelization

//        A Scheduler will provide a thread from its pool that will push the emissions.
//        When onComplete() is called, the operation will be disposed of and the thread will be given
//        back to the pool, where it may be persisted and reused by another Observer.

        // Types of Schedulers

//        IO
        // IO tasks such as reading and writing databases, web requests, and disk storage are less
        // expensive on the CPU and often have idle time waiting for the data to be sent or come back.
        // This means you can create threads more liberally, and Schedulers.io() is appropriate for this.
        // It will maintain as many threads as there are tasks and will dynamically grow, cache,
        // and reduce the number of threads as needed.

//        New Thread
        // The Schedulers.newThread() factory will return a Scheduler that does not pool threads at all.
        // It will create a new thread for each Observer and then destroy the thread when it is done.
        // This is different than Schedulers.io() because it does not attempt to persist and cache
        // threads for reuse.

//        Single
        // When you want to run tasks sequentially on a single thread, you can invoke Schedulers.single().
        // This is backed by a single-threaded implementation appropriate for event looping.
        // It can also be helpful to isolate fragile, non-threadsafe operations to a single thread.


//        SubscribeON

//        The subscribeOn() operator will suggest to the source Observable upstream which Scheduler to
//        use and how to execute operations on one of its threads.

//        You can put subscribeOn() anywhere in the Observable chain, and it will suggest to the
//        upstream all the way to the origin Observable which thread to execute emissions with.

//        Having multiple Observers to the same Observable with subscribeOn() will result in each one
//        getting its own thread (or have them waiting for an available thread if none are available).

//        if you have multiple subscribeOn() calls on a given Observable chain, the top-most one, or
//        the one closest to the source, will win and cause any subsequent ones to have
//        no practical effect (other than unnecessary resource usage).

        /// Buffering

//        bufferRangeExamples();

//        bufferTimingExample();

//        throttleExample();

//        switchingExample();


//        flowableExample();

//        flowableToObservable();

//        observableToFlowable();

//        BACKPRESSURE

//        backPressureBufferExample();

//        backPressureLatestExample();

//        backPressureDropExample();

//        TRANSFORMERS AND CUSTOM OPERATORS

//        In RxJava, there are ways to implement your own custom operators using the compose() and lift() methods,
//        which exist on both Observable and Flowable. Most of the time, you will likely want to
//        compose existing RxJava operators to create a new operator.

//        composeExample();

    }

    private void deferExample() {

        /*Observable observable = Observable.range(startCount, finalCount);
        observable.subscribe(integer -> printLog("Observer 1 = " + integer.toString()));
//        startCount = 10;
        observable.subscribe(integer -> printLog("Observer 2 " + integer.toString()));*/

        // The output of the above example would be
        // Observer 1 = 0 Observer 1 = 1 Observer 1 = 2 Observer 1 = 3 Observer 1 = 4
        // Observer 2 = 0 Observer 2 = 1 Observer 2 = 2 Observer 2 = 3 Observer 2 = 4

        // Defer will resolve this

        Observable<Integer> observable1 = Observable.defer(() -> Observable.range(startCount, finalCount));
        observable1.subscribe(integer -> printLog("Observer 1 = "+integer.toString()));
        startCount = 10;
        observable1.subscribe(integer -> printLog("Observer 2 = "+integer.toString()));
    }

    private void composeExample() {
        Observable.range(1, 15)
                .compose(toArrayList())
                .subscribe(integers -> printLog("Size = " + integers.size()));

        Observable.just("Rajat", "Arora", "Jatin", "Shubham", "Anish")
                .compose(joinToString("/"))
                .subscribe(strings -> printLog("would be = " + strings));
    }

    public <T> ObservableTransformer<T, List<T>> toArrayList() {
        // We will target any generic type T for a given Observable<T>,
        // and R will be an List<T> emitted through an Observable<List<T>>.
        // We will package all of this up in an ObservableTransformer<T,List<T>> implementation
        return upstream -> upstream.toList().toObservable();
        // Since collect() returns a Single, we will invoke toObservable() on it since ObservableTransformer
        // expects an Observable, not Single, to be returned.
    }

    public ObservableTransformer<String, String> joinToString(String seprator) {
        return upstream -> upstream.collect(StringBuilder::new, (u, s) -> {
            if (s.length() == 0)
                u.append(s);
            else
                u.append(seprator).append(s);
        }).map(StringBuilder::toString)
                .toObservable();
    }

    private void backPressureLatestExample() {
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureLatest()
                .observeOn(Schedulers.io())
                .subscribe(aLong -> printLog(aLong.toString()));
    }

    private void backPressureDropExample() {
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureDrop(aLong -> printLog("droping = " + aLong))
                .observeOn(Schedulers.io())
                .subscribe(aLong -> printLog(aLong.toString()));
    }

    private void backPressureBufferExample() {
        // For documentation refer to operatorsRxJava File

        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer()
                .observeOn(Schedulers.io())
                .subscribe(aLong -> printLog(aLong.toString()));

        // As per the documentation the problem with backpressure buffer is in some cases it get
        // overloads because of the slow consumption of the events by the downline. To avoid these
        // there are some Overflow Strategies available.

//        ERROR - Simply throws an error the moment capacity is exceeded

//        DROP_OLDEST - Drops the oldest value from the buffer to make way for a new one

//        DROP_LATEST - Drops the latest value from the buffer to prioritize older, unconsumed values

        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureBuffer(10, () -> System.out.println("overflow!"),
                        BackpressureOverflowStrategy.DROP_LATEST)
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    sleep(5);
                    System.out.println(i);
                });
        sleep(5000);

    }

    private void observableToFlowable() {
        Observable.fromIterable(namesArray)
                .toFlowable(BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(s -> printLog(s));
    }

    private void flowableToObservable() {
        Flowable<Integer> integerFlowable = Flowable.range(1, namesArray.size());
        Observable.fromIterable(namesArray)
                .flatMap(s -> integerFlowable.map(integer -> integer.toString() + s).toObservable())
                .subscribe(s -> printLog(s));
    }

    private void flowableExample() {
        /// In this example the flowable is not emitting all the values in one go.
//        Flowable.range(1, 1000)
//                .doOnNext(integer -> printLog("Emitting " + integer))
//                .observeOn(Schedulers.io())
//                .map(integer -> intenseCalculation(integer))
//                .subscribe(integer -> printLog("Output " + integer));

        Flowable.range(1, 1000)
                .doOnNext(integer -> printLog("Emitting " + integer))
                .observeOn(Schedulers.io())
                .map(integer -> intenseCalculation(integer))
                .subscribe(new FlowableSubscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(1000);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        sleep(100);
                        printLog(integer.toString());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void switchingExample() {

        Observable<String> processedString = Observable.fromIterable(namesArray)
                .concatMap(s -> Observable.just(s).delay(randomSleepTime(), TimeUnit.MILLISECONDS));

        Observable.interval(5, TimeUnit.SECONDS)
                .switchMap(aLong -> processedString.doOnDispose(() ->
                        printLog("Disposing ")))
                .subscribe(s -> printLog(s));

        // switchMap() is just like flatMap() except that it will cancel any previous Observables
        // that were processing and only chase after the latest one. This can be helpful in many
        // situations to prevent redundant or stale work and is especially effective in user
        // interfaces where rapid user inputs create stale requests.
        // You can use it to cancel database queries, web requests, and other expensive tasks and
        // replace it with a new task.
    }

    private void throttleExample() {

        Observable<String> source1 = Observable.interval(100, TimeUnit.MILLISECONDS)
                .map(aLong -> (aLong + 1) * 100)
                .map(aLong -> "Observable 1 " + aLong)
                .take(10);
        Observable<String> source2 = Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(aLong -> (aLong + 1) * 300)
                .map(aLong -> "Observable 2 " + aLong)
                .take(10);
        Observable<String> source3 = Observable.interval(500, TimeUnit.MILLISECONDS)
                .map(aLong -> (aLong + 1) * 500)
                .map(aLong -> "Observable 3 " + aLong)
                .take(10);

        Observable.concat(source1, source2, source3)
                .throttleLast(1, TimeUnit.SECONDS)
                .subscribe(s -> printLog(s));
        // In output we will get all emission which which will be emitted by all three observables.
        // The output would be Observable 1


    }

    private void bufferTimingExample() {
        // You can use buffer() at fixed time intervals by providing a long and TimeUnit.
        // To buffer emissions into a list at 1-second intervals,
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(aLong -> (aLong + 1) * 300)
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(longs -> printLog("Time Buffer = " + longs));

        // a third count argument to provide a maximum buffer size.
        // This will result in a buffer emission at each time interval or when count is reached,
        // whichever happens first. If the count is reached right before the time window closes,
        // it will result in an empty buffer being emitted.
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(aLong -> (aLong + 1) * 300)
                .buffer(1, TimeUnit.SECONDS, 3)
                .subscribe(longs -> printLog("Time Buffer = " + longs));

        // The other observable will act as the boundary to buffer.
        Observable<Long> boundaryObservable = Observable.interval(1, TimeUnit.SECONDS);
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(aLong -> (aLong + 1) * 300)
                .buffer(boundaryObservable)
                .subscribe(longs -> printLog("Time Buffer = " + longs));

    }

    private void bufferRangeExamples() {
        // Fixed Size buffering
        Observable.range(1, 10)
                .buffer(8)
                .subscribe(integers -> printLog(integers.toString()));

        // Output would be [1, 2, 3, 4, 5, 6, 7, 8] [9, 10]

        // Note if the specified count is greater than the range then it will emit all the
        // source elements in one go

        // Java collection operators with the emission
        Observable.fromIterable(namesArray)
                .buffer(5, LinkedHashSet::new)
                .subscribe(integers -> printLog("HashSet = " + integers.toString()));

        // Skip with buffer
        // If skip is equal to count, the skip has no effect.
        // The first argument is the buffer range and the secong argument is the skip period
        Observable.range(1, 50)
                .buffer(2, 5)
                .subscribe(integers -> printLog("Skip = " + integers.toString()));


    }

    private void behaviourSubjectExample() {
        Subject<String> source = BehaviorSubject.create();

        source.subscribe(s -> printLog("Source 1 " + s));

        source.onNext("Rajat");
        source.onNext("Arora");
        source.onNext("Achal");
        source.onNext("Arora");

        sleep(3000);

        source.subscribe(s -> printLog("Source 2 " + s));

        //  when we need a Subject and want to cache the last emission for new Observers,
        // you will want to use a BehaviorSubject.
    }

    private void publishSubjectExample() {
        Observable<String> observable1 = Observable.just("1", "2");
        Observable<String> observable2 = Observable.just("Rajat", "Arora");

        Subject<String> source = PublishSubject.create();
        source.subscribe(s -> printLog(s));
        observable1.subscribe(source);
        observable2.subscribe(source);
    }

    private void cacheExample() {
//      When you want to cache all emissions indefinitely for the long term and do not need to control
//      the subscription behavior to the source with ConnectableObservable, you can use the cache()
//      operator
        Observable<String> observable = Observable.fromIterable(namesArray).cache();
        observable.subscribe(s -> printLog(s));

        Observable<String> observable1 = Observable.fromIterable(namesArray)
                .cacheWithInitialCapacity(2);
        observable1.subscribe(s -> printLog(s));
    }

    private void replayExample() {
//        The replay() operator is a powerful way to hold onto previous emissions within a certain
//        scope and re-emit them when a new Observer comes in.

//        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
//                .replay().autoConnect();
//
//        observable.subscribe(aLong -> printLog("Observer 1 = " + aLong));
//        sleep(5000);
//        observable.subscribe(aLong -> printLog("Observer 2 = " + aLong));

        // The output of the above code should be
//        Observer 1: 0
//        Observer 1: 1
//        Observer 1: 2
//        Observer 1: 3
//        Observer 1: 4
//        Observer 2: 0
//        Observer 2: 1
//        Observer 2: 2
//        Observer 2: 3
//        Observer 2: 4
//        Observer 1: 5
//        Observer 2: 5

//        If we called replay(2) on our second Observer to cache the last two emissions,
//        it will not get 2,1,0  but it will receive 3 and 4.


//       if you always want to persist the cached values in your replay()
//       even if there are no subscriptions, use it in conjunction with autoConnect(), not refCount().

        Observable<String> observable1 = Observable.fromIterable(namesArray)
                .replay(2).autoConnect();
        observable1.subscribe(s -> printLog("Observer 1 = " + s));
        observable1.subscribe(s -> printLog("Observer 2 = " + s));


        // if we replace the autoConnect with refCount then the observer 2 will get all the names
        // not the last two name because once the on complete of observer 1 get called it will reset
        // the source so in output ww will be getting all names by the log tag of observer 2.

    }

    private void refCountExample() {

//        The refCount() operator on ConnectableObservable is similar to
//        autoConnect(1), which fires after getting one subscription.
//        But there is one important difference; when it has no Observers anymore,
//        it will dispose of itself and start over when a new one comes in.
//        It does not persist the subscription to the source when it has no more Observers,
//        and when another Observer follows, it will essentially "start over".

//        Look at this example: we have Observable.interval() emitting every second,
//        and it is multicast with refCount(). Observer 1 takes five emissions, and Observer 2
//        takes two emissions. We stagger their subscriptions with our sleep() function to put
//        three- second gaps between them. Because these two subscriptions are finite due to the
//        take() operators, they should be terminated by the time Observer 3 comes in, and there
//        should no longer be any previous Observers. Note how Observer 3 has started over with a
//        fresh set of intervals starting at 0!


        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .publish().refCount().take(5);
        observable.subscribe(aLong -> printLog("Observer 1 = " + aLong));

        sleep(3000);

        observable.take(2).subscribe(aLong -> printLog("Observer 2 = " + aLong));

        sleep(3000);

        observable.subscribe(aLong -> printLog("Observer 3 = " + aLong));


    }

    private void autoConnectExample() {

        // autoConnect will connect all the observers specified. If we wont specify any number in
        // autoConnect by default it will consider it 1

        // Here we specify 2 in autoConnect, Now the emission will take place for first two observers.
        // i.e. the first snd second observer will receive the emission, and third one will not.

        Observable<Integer> observable = Observable.range(1, 5).publish().autoConnect(2);
        observable.subscribe(integer -> printLog("First " + integer.toString()));
        observable.subscribe(integer -> printLog("Second " + integer.toString()));
        observable.subscribe(integer -> printLog("Three " + integer.toString()));


    }

    private void publishExample() {
        /*Observable<Integer> observable = Observable.range(1, 5);
        observable.subscribe(integer -> printLog("First " + integer.toString()));
        observable.subscribe(integer -> printLog("Second " + integer.toString()));

        // The output of the above code is First 1, First 2,First 3 Second 1, Second 2, Second 3
        // Here when first observer oncomplete get called then second observer emission started.


        ConnectableObservable<Integer> connectableObservable = Observable.range(1, 3).publish();
        connectableObservable.subscribe(integer -> printLog("First " + integer.toString()));
        connectableObservable.subscribe(integer -> printLog("Second " + integer.toString()));
        connectableObservable.connect();

        // Using ConnectableObservable will force emissions from the source to become hot,
        // pushing a single stream of emissions to all Observers at the same time rather than
        // giving a separate stream to each Observer*/


        ConnectableObservable<Integer> connectableObservable1 = Observable.range(1, 3).publish();
        connectableObservable1.map(integer -> randomInt())
                .subscribe(integer -> printLog("First " + integer.toString()));

        connectableObservable1.map(integer -> randomInt())
                .subscribe(integer -> printLog("Second " + integer.toString()));
        connectableObservable1.connect();

        // The output of the above code is that the first observer and second observer will print
        // different values.
        // This occurred because we multicast after Observable.range(), but the multicasting happens
        // before the map() operator. Even though we consolidated to one set of emissions coming
        // from Observable.range(), each Observer is still going to get a separate stream at map().
        // Everything before publish() was consolidated into a single stream (or more technically,
        // a single proxy Observer). But after publish(), it will fork into separate streams
        // for each Observer again.

        // If we want to prevent the map() operator from yielding two separate streams for each
        // Observer, we need to call publish() after map() instead:

        ConnectableObservable<Integer> connectableObservable2 = Observable.range(1, 3)
                .map(integer -> randomInt())
                .publish();

        connectableObservable2
                .subscribe(integer -> printLog("First " + integer.toString()));

        connectableObservable2
                .subscribe(integer -> printLog("Second " + integer.toString()));
        connectableObservable2.connect();

        // The output of the above code should be the same values for both the cases First and Second.


    }

    private void groupByObservableExample() {
        Observable<GroupedObservable<Integer, String>> byLength =
                Observable.fromIterable(namesArray).groupBy(s -> s.length());
        byLength.flatMapSingle(integerStringGroupedObservable -> integerStringGroupedObservable.toList())
                .filter(strings -> strings.size() > 1)
                .subscribe(System.out::println);

        /// Output
//        [Rajat, Arora, Achal, Arora, Rajat]
    }

    private void zipExample() {
//        Zipping allows you to take an emission from each Observable source and combine
//         it into a single emission.

        Observable<String> observable1 = Observable.fromIterable(namesArray);
        Observable<String> observable2 = Observable.just("Test", "Other User", "Demo Item");

        Observable.zip(observable1, observable2, (s, s2) -> s + "-" + s2)
                .subscribe(s -> printLog(s));

//        If one Observable calls onComplete() and the other still has emissions waiting to get paired,
//        those emissions will simply drop, since they have nothing to couple with.

        //    Output would be
        //    Rajat-Test
        //    Arora-Other User
        //    Achal-Demo Item

    }

    private void concatMapExample() {
        // concat map works exactly like flatmap, but it ensures the emission in sequential order, whereas
        // in case of flat maps it could be non-sequential.

        Observable.fromIterable(namesArray)
                .concatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(s -> printLog(s));
    }

    private void concatExample() {
        /// Combining two or more observables.

//        if you explicitly want to fire elements of each Observable sequentially
//        and keep their emissions in a sequential order.

        // you should never use concat if you have infinite number of emission in any observable
        // because, the second observable emission will take place when first observable oncomplete
        // get called.

        Observable<String> observable1 = Observable.just("1", "2");
        Observable<String> observable2 = Observable.fromIterable(namesArray);
        Observable.concat(observable1, observable2)
                .subscribe(s -> printLog(s));
    }

    private void flatMapExample() {
        Observable<String> source =
                Observable.just("521934/2342/FOXTROT", "21962/12112/78886/TANGO",
                        "283242/4542/WHISKEY/2348562");
        source.flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("[0-9]+"))
                .map(s -> Integer.parseInt(s))
                .subscribe(s -> printLog(s.toString()));
    }

    private void mergeArrayExample() {
//        If you have more than four Observable<T> sources, you can use the Observable.mergeArray()

        Observable<String> observable1 = Observable.just("TestUser1", "TestUser2");
        Observable<String> observable2 = Observable.just("TestUser3", "TestUser4");
        Observable<String> observable3 = Observable.fromIterable(namesArray);

        // there are two methods to achieve this

        Observable.mergeArray(observable1, observable2, observable3)
                .subscribe(s -> printLog(s));

        Observable.merge(Arrays.asList(observable1, observable2, observable3))
                .subscribe(s -> printLog(s));

    }

    private void mergeExample() {
        /// Combining two or more observables.
        Observable<String> observable1 = Observable.just("1", "2");
        Observable<String> observable2 = Observable.fromIterable(namesArray);
        Observable.merge(observable1, observable2)
                .subscribe(s -> printLog(s));

        // another approach to merge is
        /// Combining two or more observables.
        observable1.mergeWith(observable2)
                .subscribe(s -> printLog("merge with " + s));


//        The Merge operator is also similar. It combines the emissions of two or more Observables,
//        but may interleave them, whereas Concat never interleaves the emissions from multiple Observables.
    }

    private void retryExample() {
        //If you call retry() with no arguments,
        // it will resubscribe an infinite number of times for each error.

        // It might be safer to specify a fixed number of times to retry() before it gives up and
        // just emits the error to the Observer. In the following code snippet, we will only retry two times:

        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .retry(2)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e));
    }

    private void onErrorResumeExample() {
//        It accepts another Observable as a parameter to emit potentially multiple values,
//        not a single value, in the event of an exception.

        Observable.just(1, 5, 4, 2, 3, 0, 5, 6)
                .map(integer -> 10 / integer)
                .onErrorResumeNext(Observable.just(-1).repeat(3))
                .subscribe(integer -> printLog(integer.toString()));

        // the output would be 10,2,2,5,3,-1,-1,-1


//        We can also pass it Observable.empty() to quietly stop emissions in the event
//        that there is an error and gracefully call the onComplete().

        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .onErrorResumeNext(Observable.empty())
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e));
    }

    private void onErrorReturnItemExample() {
        // This is used to catch the exception and we can return any default value when exception
        // occurs during the process. Here we are returning -1 as the default value which will comes
        // play when 10/0 creates arithmetic exceptions.
        // In this case we don't have throwable just a default item which will execute
        // in the case of exception.
        Observable.just(1, 5, 4, 2, 3, 0, 5, 6)
                .map(integer -> 10 / integer)
                .onErrorReturnItem(-1)
                .subscribe(integer -> printLog(integer.toString()));

        // but the prime problem still remain the same. The program won't work after tg exception.
        // so in this case can follow the below mentioned approach.

        Observable.just(1, 5, 4, 2, 3, 0, 5, 6)
                .map(integer -> {
                    try {
                        return 10 / integer;
                    } catch (Exception e) {
                        return -1;
                    }
                }).subscribe(integer -> printLog(integer.toString()));
    }

    private void onErrorReturnExample() {
        // This is used to catch the exception and we can return any default value when exception
        // occurs during the process. Here we are returning -1 as the default value which will comes
        // play when 10/0 creates arithmetic exceptions.
        Observable.just(1, 5, 4, 2, 3, 0, 5, 6)
                .map(integer -> 10 / integer)
                .onErrorReturn(throwable -> -1)
                .subscribe(integer -> printLog(integer.toString()),
                        throwable -> printLog(throwable.getLocalizedMessage()));
    }

    private void collectExample() {
        // When none of the collection operators have what you need, you can always use the collect()
        // operator to specify a different type to collect items into.
        Observable.just("Rajat", "Shubham", "Rohit", "Jatin", "Sukhi")
                .collect(() -> new ArrayList<String>(), (strings, s) -> strings.add(s))
                .subscribe(strings -> printLog(strings.toString()));
    }

    private void toMultiMapExample() {
        Observable.fromIterable(namesArray)
                .toMultimap(strings -> strings.charAt(0))
                .subscribe(characterCollectionMap ->
                        printLog(characterCollectionMap.toString()));

        // Output would be
        // {O=[OM], R=[Rajat, Raj, Rajat], A=[Arora, Achal, Arora], S=[Shubham]}
    }

    private void toMapExample() {
        // The s -> s.charAt(0) lambda argument takes each string and derives the key to pair it
        // with. In this case, we are making the first character of that string the key.
        Observable.fromIterable(namesArray)
                .toMap(s -> s.charAt(0))
                .subscribe(characterStringMap -> printLog(characterStringMap.toString()));
    }

    private void toSortedListExample() {
        Observable.just(1, 3, 2, 5, 4, 6, 5, 6)
                .toSortedList()
                .subscribe(integers -> printLog(integers.toString()));
    }

    private void toListExample() {
        // For a given Observable<T>, it will collect incoming emissions into a List<T>
        // and then push that entire List<T> as a single emission (through Single<List<T>>).
        // In the following code snippet, we collect string emissions into a List<String>.
        // After the preceding Observable signals onComplete(), that list is pushed forward
        // to the observer to be printed:
        Observable.just("Rajat", "Achal", "Anish", "Rohit", "Shubham")
                .toList()
                .subscribe(strings -> printLog(strings.toString()));
    }

    private void containsExample() {
//        The contains() operator will check whether a specific element(based on the hashCode()/equals() implementation)
//        ever emits from an Observable. It will return a Single<Boolean> that will emit true if it is found
//        and false if it is not.

        Observable.fromIterable(namesArray)
                .contains("Rohit")
                .subscribe(aBoolean -> printLog(aBoolean.toString()));
    }

    private void anyExample() {
        // This operator check all emitted item if a single item satisfies the condition it will
        // return true and if no item satisfies the condition then only it will return false.

        Observable.fromIterable(namesArray)
                .any(s -> s.length() > 5)
                .subscribe(aBoolean ->
                        printLog(aBoolean.toString()));
        // The output would be true because the item "shubham" satisfies the condition.

//        If you call any() on an empty Observable, it will emit false due to the principle of
//        vacuous truth. You can read more about vacuous truth on Wikipedia at
//        https://en.wikipedia.org/wiki/Vacuous_truth.
//
    }

    private void allExample() {
        // It will verify all the emitted items and if all the items satisfies the condition
        // it will return true and if one item fails to verify the condition it will return false.

        Observable.fromIterable(namesArray)
                .all(s -> s.length() > 1)
                .subscribe(aBoolean -> printLog(aBoolean.toString()));
        /// Output would be true (All elements length are greater than one)

        Observable.fromIterable(namesArray)
                .all(s -> s.length() > 4)
                .subscribe(aBoolean -> printLog(aBoolean.toString()));
        /// Output would be false (All elements length are not greater than four)

        // If you call all() on an empty Observable, it will emit true due to the principle of
        // vacuous truth. You can read more about vacuous truth on
        // Wikipedia at https://en.wikipedia.org/wiki/Vacuous_truth.
    }

    private void reduceExample() {
        // This accumulates all the item into single, but the main difference between
        // reduce and scan operator is -> scan operator works while emission but
        // reduce operator work after the on complete is called
        Observable.fromIterable(namesArray)
                .reduce((total, next) -> total + next)
                .subscribe(this::printLog);
    }

    private void countExample() {
        /// counting the number of emissions
        Observable.fromIterable(namesArray)
                .count()
                .subscribe(aLong -> printLog(aLong.toString()));
    }

    private void scanExample() {
        // Adding in sequence and emission will take place
        // output would be 3 7 12 18 25
        Observable.just(3, 4, 5, 6, 7)
                .scan((accumulator, next) -> accumulator + next)
                .subscribe(integer -> printLog(integer.toString()));
    }

    private void repeatExample() {
        // repeat the emitted items two times
        // if we don't specify the repeat count it will repeating emission continously.
        Observable.fromIterable(namesArray)
                .repeat(2)
                .subscribe(s -> printLog(s));
    }

    private void delayExample() {
        /// delayed emission from source by three seconds.
        Observable.fromIterable(namesArray)
                .delay(3, TimeUnit.SECONDS)
                .subscribe(s -> printLog(s));

    }

    private void sortedExample() {
        /// Elements in sorted order
        Observable.fromIterable(namesArray).
                sorted()
                .subscribe(s -> printLog(s));
    }

    private void switchIfEmptyExample() {
        // If source observable doesn't contain a value then
        // it will switch to another observable

        // The first observable which doesn't have name "Rohit" in it,
        // So after filtering out the items, the output of first observable is empty.
        // As a result, the new observable comes into play with "switchIfEmptyOperator"

        Observable.fromIterable(namesArray)
                .filter(s -> s.startsWith("Rohit"))
                .switchIfEmpty(Observable.just("Shubham", "Rohit", "Jatin", "Sukhi"))
                .subscribe(s -> printLog(s));
    }

    private void defaultIsEmptyExample() {
        Observable.fromIterable(namesArray)
                .filter(s -> s.startsWith("Rohit"))
                .defaultIfEmpty("None of the above")
                .subscribe(s -> printLog(s));
    }

    private void startWithArrayExample() {
        /// It add multiple item before the emitted items
        Observable.fromIterable(namesArray)
                .startWithArray("FAMILY ", "NAMES", "LIST")
                .subscribe(s -> printLog(s));
    }

    private void startWithExample() {
        // Add value at the top of the emitted items
        Observable.fromIterable(namesArray)
                .startWith("FAMILY NAMES")
                .subscribe(s -> printLog(s));
    }

    private void castExample() {
        // If you find that you are having typing issues due to inherited or polymorphic types
        // being mixed, this is an effective brute-force way to cast everything down to a common
        // base type.
        Observable.fromIterable(namesArray)
                .cast(Object.class);
    }

    private void mapExample() {
        // convert one object type into another.
        // Here converting string to integer.
        Observable.fromIterable(namesArray)
                .map(s -> s.length())
                .subscribe(integer -> printLog(integer.toString()));
    }

    private void elementAtOrErrorExample() {
        Observable.fromIterable(namesArray)
                .elementAtOrError(10)
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        printLog(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        printLog(e.toString());
                    }
                });
    }

    private void elementAtExample() {
        // You can get a specific emission by its index specified by a Long, starting at 0.
        // After that item is found and emitted, onComplete() will be called and the subscription
        // will be disposed of.

        // If the element doesn't exist at the specified position then it will print nothing

        Observable.fromIterable(namesArray)
                .elementAt(3)
                .subscribe(s -> printLog(s));
    }

    private void distinctUntilChanged() {
        /// It will accept the emitted value until the values gets changed in the emitted list
        Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
                .distinctUntilChanged()
                .subscribe(integer -> printLog(integer.toString()));
    }

    private void distinctExample() {
        // Distinct operator is used to avoid duplicate values.
        Observable.fromIterable(namesArray)
                .distinct()
                .subscribe(s -> printLog(s));
    }

    private void skipWhileExample() {
        Observable.fromIterable(namesArray)
                .skipWhile(s -> s.length() > 4)
                .subscribe(s -> printLog(s));
    }

    private void takeWhileExample() {
        // take while will emit the item till the condition is true, Once the condtion got false it
        // will not emit further items either they are satisfying the conditions.
        Observable.fromIterable(namesArray)
                .takeWhile(s -> s.length() > 4)
                .subscribe(s -> printLog(s));
    }

    private void skipLastExample() {
        // Initially it will process all the emission then skip lat would be called.
        Observable.fromIterable(namesArray)
                .skipLast(2)
                .subscribe(s -> printLog(s));
    }

    private void skipExample() {
        Observable.fromIterable(namesArray)
                .skip(5)
                .subscribe(s -> printLog(s));
    }

    private void takeLastExample() {
        /// Emit last two values
        Observable.fromIterable(namesArray)
                .takeLast(2)
                .subscribe(s -> printLog(s));
    }

    private void takeExample() {
        // take only specified input and call onComplete

        // If the specified number is greater than the emission content,
        // then it will emit all the values present in the source.

        Observable.fromIterable(namesArray)
                .take(3)
                .subscribe(s -> printLog(s));
    }

    private void subscribeWithExample() {
        compositeDisposable.add(Observable.fromIterable(namesArray).
                subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    private void completableExample() {
        /* Completable is simply concerned with an action being executed,
           but it does not receive any emissions.
           Logically, it does not have onNext() or onSuccess() to receive emissions,
           but it does have onError() and onComplete()

           Completable is something you likely will not use often.
           You can construct one quickly by calling Completable.complete()
           or Completable.fromRunnable().
           The former will immediately call onComplete() without doing anything,
           while fromRunnable() will execute the specified action before calling onComplete() */

        Completable.fromRunnable(() -> {
            printLog("Runnbale");
        }).subscribe(new DisposableCompletableObserver() {
            @Override
            public void onComplete() {
                printLog("onComplete");
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }

    private void extractFirstElement() {
        /* One example is the firstElement() operator, which is similar to first(),
         but it returns an empty result if no elements are emitted. */

        Observable.fromIterable(namesArray)
                .firstElement()
                .subscribe(s ->
                        printLog(s));
    }

    private void maybeExample() {
        /* A given Maybe<T> will only emit 0 or 1 emissions.
        It will pass the possible emission to onSuccess(), and in either case,
        it will call onComplete() when done.
        Maybe.just() can be used to create a Maybe emitting the single item.
        Maybe.empty() will create a Maybe that yields no emission */

        Maybe.just(namesArray)
                .subscribe(new MaybeObserver<List<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<String> strings) {
                        printLog(String.valueOf(strings.size()));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void extractFirstElementWithDefaultValue() {

        /* For instance, the first() operator will return a Single since
        that operator is logically concerned with a single item.However, it accepts a default
        value as a parameter (which I specified as (Nothing Specified) in the following example)
        if the Observable comes out empty */

        Observable.fromIterable(namesArray).
                first("Nothing Specified")
                .subscribe(s ->
                        printLog(s));
    }

    private void singleExample() {
        Single.just("Hello World")
                .map(String::length)
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Integer integer) {
                        printLog(integer.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    private void observablesWithRange() {
        Observable<Integer> observable = Observable.range(4, 10);

        observable.subscribe(integer -> printLog(integer.toString()));
    }

    private void connectableObservables() {
        ConnectableObservable<String> observable = Observable.fromIterable(namesArray).publish();
        observable.subscribe(s -> printLog(s));

        observable.map(s -> s.length())
                .subscribe(integer -> printLog(integer.toString()));

        observable.connect();
    }

    private void observableWithLambdas() {
        Observable<String> observable = Observable.fromIterable(namesArray);
        observable.subscribe(s -> printLog(s),
                throwable -> {

                }
                , () -> printLog("done")
        );
    }

    private void observableWithIterable() {
        Observable<String> observable = Observable.fromIterable(namesArray);
        observable.subscribe(new DisposableObserver<String>() {
            @Override
            public void onNext(String s) {
                printLog(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                printLog("onComplete");
            }
        });

        observable.subscribe(s -> printLog(s),
                throwable -> {

                }
                , () -> printLog("done")
        );
    }

    private void observableWithFilter() {

        Observable.fromIterable(namesArray)
                .filter(s -> s.length() > 4).
                subscribe(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String s) {
                        printLog(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void observablesWithEmitter() {
        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("Rajat");
            emitter.onNext("Arora");
            emitter.onComplete();
        });
        observable.subscribe(s -> printLog(s));
    }

    private void observablesWithMap() {
        Observable<String> observable = Observable.create(emitter -> {
            emitter.onNext("Rajat");
            emitter.onNext("Arora");
            emitter.onComplete();
        });
        observable.map(String::length)
                .subscribe(integer -> printLog(integer.toString()));
    }

    private void printLog(String value) {
        Log.e("Value = ", value);
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100);
    }

    private void transitionCode() {
        LinearLayout llMain = findViewById(R.id.llMain);

        TransitionDrawable transition = (TransitionDrawable) llMain.getBackground();

        Button btntransition = findViewById(R.id.btntransition);

        btntransition.setOnClickListener(view -> {
                    if (!transitionHappened) {
                        transition.startTransition(500);
                        transitionHappened = true;
                    } else {
                        transition.resetTransition();
                        transitionHappened = false;
                    }
                }
        );
    }

    public static int randomSleepTime() {
        //returns random sleep time between 0 to 2000 milliseconds
        return ThreadLocalRandom.current().nextInt(2000);
    }

    public static <T> T intenseCalculation(T value) {
        //sleep up to 200 milliseconds
        sleep(ThreadLocalRandom.current().nextInt(200));
        return value;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
