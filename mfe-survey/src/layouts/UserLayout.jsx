import React from "react";
import NavBar from "../components/Common/NavBar";
import SideBar from "../components/Common/SideBar";

const UserLayout = ({ children }) => {
  return (
    <section>
      <NavBar />
      <div style={{ display: "flex" }}>
        <SideBar />
        <main className="page-content">{children}</main>
      </div>
    </section>
  );
};

export default UserLayout;
