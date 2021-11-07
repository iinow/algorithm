function findLadders(
  beginWord: string,
  endWord: string,
  wordList: string[]
): string[][] {
  let res: string[][] = []
  const memo: any = {}
  let minSize = Number.MAX_VALUE

  const valid = (a: string, b: string): boolean => {
    const as = a.split('')
    const bs = b.split('')
    let countDiff = 0
    for (let i = 0; i < as.length; i++) {
      if (as[i] !== bs[i]) {
        countDiff += 1
      }
    }

    return countDiff === 1
  }

  const recursive = (
    copyWordList: string[] = wordList,
    values: string[] = [beginWord]
  ) => {
    if (minSize < values.length) {
      return
    }

    if (values[values.length - 1] === endWord) {
      const arr = [...values]
      if (minSize !== arr.length) {
        res = []
      }
      res.push(arr)
      minSize = Math.min(minSize, arr.length)
      return
    }

    for (let i = 0; i < copyWordList.length; i++) {
      if (valid(values[values.length - 1], copyWordList[i])) {
        recursive(
          copyWordList.filter((_, index) => index !== i),
          [...values, copyWordList[i]]
        )
      }
    }
  }

  recursive()
  return res
}

console.log(
  findLadders('qa', 'sq', [
    'si',
    'go',
    'se',
    'cm',
    'so',
    'ph',
    'mt',
    'db',
    'mb',
    'sb',
    'kr',
    'ln',
    'tm',
    'le',
    'av',
    'sm',
    'ar',
    'ci',
    'ca',
    'br',
    'ti',
    'ba',
    'to',
    'ra',
    'fa',
    'yo',
    'ow',
    'sn',
    'ya',
    'cr',
    'po',
    'fe',
    'ho',
    'ma',
    're',
    'or',
    'rn',
    'au',
    'ur',
    'rh',
    'sr',
    'tc',
    'lt',
    'lo',
    'as',
    'fr',
    'nb',
    'yb',
    'if',
    'pb',
    'ge',
    'th',
    'pm',
    'rb',
    'sh',
    'co',
    'ga',
    'li',
    'ha',
    'hz',
    'no',
    'bi',
    'di',
    'hi',
    'qa',
    'pi',
    'os',
    'uh',
    'wm',
    'an',
    'me',
    'mo',
    'na',
    'la',
    'st',
    'er',
    'sc',
    'ne',
    'mn',
    'mi',
    'am',
    'ex',
    'pt',
    'io',
    'be',
    'fm',
    'ta',
    'tb',
    'ni',
    'mr',
    'pa',
    'he',
    'lr',
    'sq',
    'ye',
  ])
)
