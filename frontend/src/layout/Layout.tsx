import React from 'react';

import Header from '@/components/Header/Header';
import Footer from '@/components/Footer/Footer';

import * as S from './Layout.styled';

interface PageProps {
  children: React.ReactNode;
}

function Layout({ children }: PageProps) {
  return (
    <S.Container>
      <Header />
      <S.Content>{children}</S.Content>
      <Footer />
    </S.Container>
  );
}

export default Layout;