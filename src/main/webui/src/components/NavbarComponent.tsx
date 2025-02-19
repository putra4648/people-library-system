import MenuIcon from "@mui/icons-material/Menu";
import { AppBar, Avatar, IconButton, Toolbar, Typography } from "@mui/material";
import useDrawerStore from "../store/drawerStore";
import useProfileStore from "../store/profileStore";
import ProfileComponent from "./ProfileComponent";

export default function NavbarComponent() {
  const { toggleDrawer } = useDrawerStore();
  const { open, handleClick } = useProfileStore();

  return (
    <AppBar position="static">
      <Toolbar>
        <IconButton
          size="large"
          edge="start"
          color="inherit"
          aria-label="menu"
          sx={{ mr: 2 }}
          onClick={toggleDrawer(true)}
        >
          <MenuIcon />
        </IconButton>
        <Typography flex={1}>People Library System</Typography>
        <IconButton
          onClick={handleClick}
          size="small"
          sx={{ ml: 2 }}
          aria-controls={open ? "account-menu" : undefined}
          aria-haspopup="true"
          aria-expanded={open ? "true" : undefined}
        >
          <Avatar>M</Avatar>
        </IconButton>
        <ProfileComponent />
      </Toolbar>
    </AppBar>
  );
}
