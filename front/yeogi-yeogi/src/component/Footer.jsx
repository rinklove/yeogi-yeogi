import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';

const StyledFooterDiv = styled.div`
    border-top: 1px solid black;
    height: auto;
`;

const Footer = () => {
    return (
        <StyledFooterDiv>
            footer
            <Link to="/club/createClub"><button>클럽만들기 ㄱㄱ</button></Link>
            <Link to="/club/1/commu/board"><button>클럽 ㄱㄱ</button></Link>
            <Link to="/club/1/manage/editClub"><button>클럽정보수정 </button></Link>
        </StyledFooterDiv>
    );
};

export default Footer;