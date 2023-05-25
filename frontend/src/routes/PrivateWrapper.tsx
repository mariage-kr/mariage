import { useEffect } from 'react';
import { Outlet, useNavigate } from 'react-router-dom';

import { BROWSER_PATH } from '@/constants/path';
import useAuth from '@/hooks/useAuth';

function PrivateWrapper() {
  const navigate = useNavigate();
  const { isLogin } = useAuth();

  useEffect(() => {
    if (!isLogin()) {
      navigate(BROWSER_PATH.LOGIN);
    }
  }, []);

  return <Outlet />;
}

export default PrivateWrapper;
