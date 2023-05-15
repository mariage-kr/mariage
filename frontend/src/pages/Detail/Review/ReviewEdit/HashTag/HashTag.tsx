import { useState } from 'react';
import * as S from './HashTag.styled';


function HashTag() {

  // 해시태그 이벤트
  const [inputHashTag, setInputHashTag] = useState('');
  const [hashTags, setHashTags] = useState<string[]>([]);

  const addHashTag = (e: React.KeyboardEvent<HTMLInputElement>) => {
    let hashTag = e.currentTarget.value.trim();

    const isEmptyValue = (hashTag: string) => {
      return hashTag.length === 0;
    }

    const allowedCommand = ['Comma', 'Enter', 'Space', 'NumpadEnter'];
    if (!allowedCommand.includes(e.code)) return;

    if (isEmptyValue(hashTag)) {
      return setInputHashTag('');
    }

    const regExp = /[\{\}\[\]\/?.;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/g;
    if (regExp.test(hashTag)) {
      hashTag = hashTag.replace(regExp, '');
    }
    if (hashTag.includes(',')) {
      hashTag = hashTag.split(',').join('');
    }

    if (isEmptyValue(hashTag)) return;

    setHashTags((prevHashTags) => {
      return [...new Set([...prevHashTags, hashTag])];
    });

    setInputHashTag('');
  };

  const keyDownHandler = (e: any) => {
    if (e.code !== 'Enter' && e.code !== 'NumpadEnter') return;
    e.preventDefault();

    const regExp = /^[a-z|A-Z|가-힣|ㄱ-ㅎ|ㅏ-ㅣ|0-9| \t|]+$/g;
    if (!regExp.test(e.target.value)) {
      setInputHashTag('');
    }
  };

  const changeHashTagInput = (e: any) => {
    setInputHashTag(e.target.value);
  };

  const removeHashTag = (tag: string) => {
    setHashTags(prevHashTags => {
      return prevHashTags.filter(hashTag => hashTag !== tag);
    });
  };

  return (
    <S.Container>
      {hashTags.length > 0 &&
        hashTags.map((hashTag) => {
        return (
          <div key={hashTag} className='tag' onClick={() => removeHashTag(hashTag)}>
            #{hashTag}
          </div>
        );
      })}
      
      <S.InputHashTag
        value={inputHashTag}
        onChange={changeHashTagInput}
        onKeyUp={addHashTag}
        onKeyDown={keyDownHandler}
        disabled={hashTags.length >= 3}
        placeholder="#해시태그를 등록해보세요. (최대 3개)"
      />
    </S.Container>
  );
};

export default HashTag;