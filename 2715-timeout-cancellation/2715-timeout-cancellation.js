/**
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function(fn, args, t) {
    const cancellable=function(){
        clearTimeout(timer);
    };
    const timer=setTimeout(()=>{
        fn(...args)
    }, t);
    return cancellable;
    
};

/**
 *  const result = [];
 *
 *  const fn = (x) => x * 5;
 *  const args = [2], t = 20, cancelTimeMs = 50;
 *
 *  const start = performance.now();
 *
 *  const log = (...argsArr) => {
 *      const diff = Math.floor(performance.now() - start);
 *      result.push({"time": diff, "returned": fn(...argsArr)});
 *  }
 *       
 *  const cancel = cancellable(log, args, t);
 *
 *  const maxT = Math.max(t, cancelTimeMs);
 *           
 *  setTimeout(cancel, cancelTimeMs);
 *
 *  setTimeout(() => {
 *      console.log(result); // [{"time":20,"returned":10}]
 *  }, maxT + 15)
 */

/**
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway, yeah, yeah, yeah, yeah
Hey, hey, hey
Where do you think you're going?
It's so late, late, late
What's wrong?
I said, "I can't stay, do I have to give a reason?
It's just me, me, me, it's what I want
So how did we get here?
Three weeks now, we've been so caught up
Better if we do this on our own
Before I love you (nah, nah, nah)
I'm gonna leave you (nah, nah, nah)
Before I'm someone you leave behind
I'll break your heart so you don't break mine
Before I love you (nah, nah, nah)
I'm gonna leave you (nah, nah, nah)
Even if I'm not here to stay
I still want your heart
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway
Your heart for takeaway, yeah, yeah, yeah yeah
Fate, fate, fate
Is that what came between us?
Or did we do this on our own?
So how did we get here?
I'm asking myself why I'm so caught up
Better if we do this on our own
Before I love you (nah, nah, nah)
I'm gonna leave you (nah, nah, nah)
Before I'm someone you leave behind
I'll break your heart so you don't break mine
Before I love you (nah, nah, nah)
I'm gonna leave you (nah, nah, nah)
Even if I'm not here to stay
I still want your heart
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway, yeah, yeah, yeah, yeah
Your heart for takeaway
Your heart for takeaway, yeah, yeah, yeah, yeah
Before I love you (nah, nah, nah)
I'm gonna leave you (nah, nah, nah)
Before I'm someone you leave behind
I'll break your heart so you don't break mine
Before I love you (nah, nah, nah)
I'm gonna leave you (nah, nah, nah)
Even if I'm not here to stay
I still want your heart
 */