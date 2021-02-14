import {ICompareFunction, defaultCompare, swap, reverseCompare, Compare} from './util'
import assert from 'assert'
/**
 * 최소 힙의 자료구조에서 최상단 노드 값은 최소값을 가르킨다.
 * 최대 힙의 자료구조에서 최상단 노드 값은 최대값을 가르킨다.
 *
 * 최소 힙에서는 새로 값이 추가되면 마지막 노드에 값이 추가된다.
 * 부모 노드보다 값이 작으면 스왑한다.
 *
 * 최소 힙에서 최솟 값(최상위 노드) 를 가져오게 되면 힙에서 가장 마지막 노드를 최상위 노드로 이동 시킨다.
 * 그 후 정렬 시작
 */
interface IHeap<T> {
    heap: T[]
    insert: (val: T) => void
    swap: (parentIndex: number, lastIndex: number) => void
    get: () => T | undefined
}

class Heap implements IHeap<number> {
    heap: number[]

    constructor(arr?: number[]) {
        if (!arr) {
            arr = []
        }
        this.heap = arr
    }

    get(): number | undefined {
        return this.heap.length > 0 ? this.heap[0] : undefined
    }

    extract(): number | undefined {
        if(this.heap.length === 0) {
            return undefined
        }
        let index = 0
        const minValue = this.heap[index]
        this.heap[index] = this.heap[this.heap.length - 1]
        this.heap.splice(-1, 1)

        while(true) {
            let arr = this.getChildNodesIndex(index)
            if(arr === undefined) {
                break
            }
            if(arr.length === 1) {
                this.swap(index, arr[0])
                break
            }
            const leftValue = this.heap[arr[0]]
            const rightValue = this.heap[arr[1]]
            const minIndex = leftValue > rightValue ? arr[1] : arr[0]
            if(!this.swap(index, minIndex)) {
                break
            }

            index = minIndex
        }
    }

    insert(val: number): void {
        this.heap.push(val)
        let lastIndex = this.heap.length - 1
        while(true) {
            const parentIndex = this.getParentIndex(lastIndex)
            if(parentIndex === undefined) {
                return
            }

            if(!this.swap(parentIndex, lastIndex)) {
                break
            }
            lastIndex = parentIndex
        }
    }

    getArray(): number[] {
        return [...this.heap]
    }

    swap(parentIndex: number, lastIndex: number): boolean {
        const parentValue = this.heap[parentIndex]
        const childValue = this.heap[lastIndex]
        if(parentValue > childValue) {
            this.heap[parentIndex] = childValue
            this.heap[lastIndex] = parentValue
            return true
        }
        return false
    }

    /**
     * @param index
     * @private
     * 0, [1,2]   -> 1
     * 1, [3,4]   -> 2
     * 2, [5,6]   -> 3
     * 3, [7,8]   -> 4
     * 4, [9,10]  -> 5
     */
    private getChildNodesIndex(index: number): [number, number] | [number] | undefined {
        const rightChildIndex = 2 * index + 2
        const leftChildIndex = rightChildIndex - 1
        if(this.heap.length >= rightChildIndex) {
            return [leftChildIndex, rightChildIndex]
        }
        if(this.heap.length >= leftChildIndex) {
            return [leftChildIndex]
        }
        return undefined
    }

    private getParentIndex(index: number): number | undefined {
        if(index === 0) {
            return undefined
        }
        index = index % 2 === 1 ? index : index - 1
        return Math.floor(index / 2)
    }
}

class MinHeap<T> {
    protected heap: T[] = [];

    constructor(protected compareFn: ICompareFunction<T> = defaultCompare) {
    }

    private getLeftIndex(index: number) {
        return 2 * index + 1;
    }

    private getRightIndex(index: number) {
        return 2 * index + 2;
    }

    private getParentIndex(index: number) {
        if (index === 0) {
            return 0;
        }
        return Math.floor((index - 1) / 2);
    }

    size() {
        return this.heap.length;
    }

    isEmpty() {
        return this.size() <= 0;
    }

    clear() {
        this.heap = [];
    }

    findMinimum() {
        return this.isEmpty() ? undefined : this.heap[0];
    }

    insert(value: T) {
        if (value != null) {
            const index = this.heap.length;
            this.heap.push(value);
            this.siftUp(index);
            return true;
        }
        return false;
    }

    private siftDown(index: number) {
        let element = index;
        const left = this.getLeftIndex(index);
        const right = this.getRightIndex(index);
        const size = this.size();

        if (left < size && this.compareFn(this.heap[element], this.heap[left]) === Compare.BIGGER_THAN) {
            element = left;
        }

        if (
            right < size &&
            this.compareFn(this.heap[element], this.heap[right]) === Compare.BIGGER_THAN
        ) {
            element = right;
        }

        if (index !== element) {
            swap(this.heap, index, element);
            this.siftDown(element);
        }
    }

    private siftUp(index: number): void {
        let parent = this.getParentIndex(index);
        // @ts-ignore
        while (
            index > 0 &&
            this.compareFn(this.heap[parent], this.heap[index]) === Compare.BIGGER_THAN
            ) {
            swap(this.heap, parent, index);
            index = parent;
            parent = this.getParentIndex(index);
        }
    }

    extract(): T | undefined {
        if (this.isEmpty()) {
            return undefined;
        }
        if (this.size() === 1) {
            return this.heap.shift();
        }
        const removedValue = this.heap[0];
        // @ts-ignore
        this.heap[0] = this.heap.pop();
        this.siftDown(0);
        return removedValue;
    }

    heapify(array: T[]) {
        if (array) {
            this.heap = array;
        }

        const maxIndex = Math.floor(this.size() / 2) - 1;

        for (let i = 0; i <= maxIndex; i++) {
            this.siftDown(i);
        }

        return this.heap;
    }

    getAsArray() {
        return this.heap;
    }
}

export class MaxHeap<T> extends MinHeap<T> {
    constructor(protected compareFn: ICompareFunction<T> = defaultCompare) {
        super(compareFn);
        this.compareFn = reverseCompare(compareFn);
    }
}

describe('heap', () => {
    it('최상단 노드 값은 최소값', () => {
        let minHeap = new MinHeap()
        minHeap.insert(10)
        minHeap.insert(4)
        minHeap.insert(2)
        minHeap.insert(9)
        minHeap.insert(1)
        minHeap.insert(6)
        minHeap.insert(5)
        minHeap.insert(11)
        minHeap.insert(15)
        minHeap.insert(3)
        console.log(minHeap.getAsArray())
        minHeap.extract()
        minHeap.extract()
        console.log(minHeap.getAsArray())
        // assert.strictEqual(minHeap.extract(), 1)
    })

    it('내가 만든거', () => {
        const heap = new Heap()
        heap.insert(10)
        heap.insert(4)
        heap.insert(2)
        heap.insert(9)
        heap.insert(1)
        heap.insert(6)
        heap.insert(5)
        heap.insert(11)
        heap.insert(15)
        heap.insert(3)
        console.log(heap.getArray())
        heap.extract()
        heap.extract()
        console.log(heap.getArray())
    })
})
